package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe1;

    @BeforeEach
    void setUp() {
        coffeeMaker = new CoffeeMaker(); // also resets the static Inventory to 15 of each

        recipe1 = new Recipe();
        recipe1.setName("Coffee");
        recipe1.setPrice(50);
        recipe1.setAmtCoffee(3);
        recipe1.setAmtMilk(1);
        recipe1.setAmtSugar(1);
        recipe1.setAmtChocolate(0);
    }

   
    @Test
    void testCheckInventory() {
        // Arrange: new machine

        // Act
        Inventory inventory = coffeeMaker.checkInventory();

        // Assert
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }


    @Test
    void testEditRecipe() {
        // Arrange
        coffeeMaker.addRecipe(recipe1);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Coffee"); // name can't change
        newRecipe.setPrice(60);
        newRecipe.setAmtCoffee(3);
        newRecipe.setAmtMilk(1);
        newRecipe.setAmtSugar(1);
        newRecipe.setAmtChocolate(0);

        // Act
        boolean result = coffeeMaker.editRecipe(recipe1, newRecipe);

        // Assert: look up by name so the test doesn't depend on which slot is used
        assertTrue(result);
        assertEquals(60, coffeeMaker.getRecipeForName("Coffee").getPrice());
    }

    @Test
    void testGetRecipeForName() {
        // Arrange
        coffeeMaker.addRecipe(recipe1);

        // Act
        Recipe foundRecipe = coffeeMaker.getRecipeForName("Coffee");

        // Assert
        assertSame(recipe1, foundRecipe);
    }

    @Test
    void testGetRecipes() {
        // Arrange
        coffeeMaker.addRecipe(recipe1);

        // Act
        Recipe[] recipes = coffeeMaker.getRecipes();

        // Assert
        assertNotNull(recipes);
        assertTrue(Arrays.asList(recipes).contains(recipe1));
    }


    private Recipe recipe(String name, int price, int coffee, int milk, int sugar, int choc) {
        Recipe r = new Recipe();
        r.setName(name);
        r.setPrice(price);
        r.setAmtCoffee(coffee);
        r.setAmtMilk(milk);
        r.setAmtSugar(sugar);
        r.setAmtChocolate(choc);
        return r;
    }

    @Test
    void testAddRecipe_duplicateName_returnsFalse() {
        // Arrange
        coffeeMaker.addRecipe(recipe1);
        Recipe duplicate = recipe("Coffee", 99, 1, 1, 1, 1);

        // Act
        boolean result = coffeeMaker.addRecipe(duplicate);

        // Assert
        assertFalse(result);
    }


    @Test
    void testDeleteRecipe_nonexistentRecipe_returnsFalse() {
        // Arrange: recipe1 was never added

        // Act
        boolean result = coffeeMaker.deleteRecipe(recipe1);

        // Assert
        assertFalse(result);
    }

    @Test
    void testDeleteRecipe_null_returnsFalse() {
        // Arrange: none

        // Act
        boolean result = coffeeMaker.deleteRecipe(null);

        // Assert
        assertFalse(result);
    }

    @Test
    void testEditRecipe_nonexistentRecipe_returnsFalse() {
        // Arrange: recipe1 was never added
        Recipe newRecipe = recipe("Coffee", 60, 3, 1, 1, 0);

        // Act
        boolean result = coffeeMaker.editRecipe(recipe1, newRecipe);

        // Assert
        assertFalse(result);
    }

    @Test
    void testEditRecipe_differentName_returnsFalse() {
        // Arrange: a recipe's name may not be changed
        coffeeMaker.addRecipe(recipe1);
        Recipe renamed = recipe("Renamed", 60, 3, 1, 1, 0);

        // Act
        boolean result = coffeeMaker.editRecipe(recipe1, renamed);

        // Assert
        assertFalse(result);
        assertEquals(50, coffeeMaker.getRecipeForName("Coffee").getPrice());
    }

    @Test
    void testAddInventory_negativeCoffee_returnsFalse() {
        assertFalse(coffeeMaker.addInventory(-1, 0, 0, 0));
    }

    @Test
    void testAddInventory_negativeMilk_returnsFalse() {
        assertFalse(coffeeMaker.addInventory(0, -1, 0, 0));
    }


    @Test
    void testAddInventory_negativeChocolate_returnsFalse() {
        assertFalse(coffeeMaker.addInventory(0, 0, 0, -1));
    }


    @Test
    void testGetRecipeForName_missingName_returnsEmptyRecipe() {
        // Arrange: one recipe present, so the loop sees a non-null name that doesn't match
        coffeeMaker.addRecipe(recipe1);

        // Act
        Recipe found = coffeeMaker.getRecipeForName("Nope");

        // Assert
        assertNotNull(found);
        assertNull(found.getName());
    }

    @Test
    void testMakeCoffee_exactPayment_returnsZeroChange() {
        assertEquals(0, coffeeMaker.makeCoffee(recipe1, 50));
    }

    @Test
    void testMakeCoffee_underpayByOne_returnsFullAmount() {
        assertEquals(49, coffeeMaker.makeCoffee(recipe1, 49));
    }

    @Test
    void testMakeCoffee_underpay_leavesInventoryUnchanged() {
        // Act
        coffeeMaker.makeCoffee(recipe1, 49);

        // Assert
        Inventory inv = coffeeMaker.checkInventory();
        assertEquals(15, inv.getCoffee());
        assertEquals(15, inv.getMilk());
        assertEquals(15, inv.getSugar());
    }

    @Test
    void testMakeCoffee_notEnoughIngredients_returnsFullAmount() {
        // Arrange: needs 16 coffee, machine has 15
        Recipe big = recipe("Big", 50, 16, 1, 1, 0);

        // Act
        int returned = coffeeMaker.makeCoffee(big, 100);

        // Assert
        assertEquals(100, returned);
    }
}
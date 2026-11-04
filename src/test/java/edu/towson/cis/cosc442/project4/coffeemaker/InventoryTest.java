package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void testEnoughIngredients() {
        // Arrange
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee(16);
        recipe.setAmtMilk(16);
        recipe.setAmtSugar(16);
        recipe.setAmtChocolate(16);

        // Act
        boolean enough = inventory.enoughIngredients(recipe);

        // Assert
        assertFalse(enough);
    }
@Test
    void testEnoughIngredients_Success() {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);

        boolean enough = inventory.enoughIngredients(recipe);
        assertTrue(enough, "Inventory should be enough for these amounts");
    }
    @Test
    void testGetChocolate() {
        // setUp

        // Act
        int amount = inventory.getChocolate();

        // Assert
        assertEquals(15, amount);
    }

    @Test
    void testGetCoffee() {
        // Arrange setUp

        // Act
        int amount = inventory.getCoffee();

        // Assert
        assertEquals(15, amount);
    }

    @Test
    void testGetMilk() {
        // Arrange setUp

        // Act
        int amount = inventory.getMilk();

        // Assert
        assertEquals(15, amount);
    }

    @Test
    void testGetSugar() {
        // Arrange setUp

        // Act
        int amount = inventory.getSugar();

        // Assert
        assertEquals(15, amount);
    }

    @Test
    void testSetChocolate() {

        // Act
        inventory.setChocolate(-1);

        // Assert
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    void testSetCoffee() {
        // Act
        inventory.setCoffee(-1);

        // Assert
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    void testSetMilk() {

        // Act
        inventory.setMilk(-1);

        // Assert
        assertEquals(0, inventory.getMilk());
    }

    @Test
    void testSetSugar() {

        // Act
        inventory.setSugar(-1);

        // Assert
        assertEquals(0, inventory.getSugar());
    }

    @Test
    void testToString() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";

        // Act
        String text = inventory.toString();

        // Assert
        assertEquals(expected, text);
    }
    @Test

void testSetChocolateBoundaryNegative() {
    //arrange 
    
    Inventory inventory = new Inventory();
    //Act
    inventory.setChocolate(-5);
    //Assert
    assertEquals(0, inventory.getChocolate());
}
@Test
    void testSettersPositiveValues() {
        inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee());

        inventory.setMilk(5);
        assertEquals(5, inventory.getMilk());

        inventory.setSugar(8);
        assertEquals(8, inventory.getSugar());

        inventory.setChocolate(12);
        assertEquals(12, inventory.getChocolate());
    }
    @Test
    void testSettersBoundaryZero() {
        // Test setting exact boundary value 0 for all ingredients
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee());

        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk());

        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar());

        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    void testEnoughIngredients_ExactBoundary() {
        // Default inventory has 15 units of each. 
        // Test when recipe requires exact match (15) to kill boundary mutants (< vs <=).
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee(15);
        recipe.setAmtMilk(15);
        recipe.setAmtSugar(15);
        recipe.setAmtChocolate(15);

        boolean enough = inventory.enoughIngredients(recipe);
        assertTrue(enough, "Inventory should be enough when ingredients match exact inventory quantities");
    }
    
}
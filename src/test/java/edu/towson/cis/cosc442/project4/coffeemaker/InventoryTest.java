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
}
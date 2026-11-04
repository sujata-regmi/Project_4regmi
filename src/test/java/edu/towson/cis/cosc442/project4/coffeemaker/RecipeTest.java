package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    void testEquals() {
        // Arrange
        recipe.setName("Mocha");
        Recipe other = new Recipe();
        other.setName("Mocha");

        // Act
        boolean result = recipe.equals(other);

        // Assert
        assertTrue(result);
    }

    @Test
    void testGetAmtChocolate() {
        // Arrange
        recipe.setAmtChocolate(5);

        // Act
        int amount = recipe.getAmtChocolate();

        // Assert
        assertEquals(5, amount);
    }

    @Test
    void testGetAmtCoffee() {
        // Arrange
        recipe.setAmtCoffee(5);

        // Act
        int amount = recipe.getAmtCoffee();

        // Assert
        assertEquals(5, amount);
    }

    @Test
    void testGetAmtMilk() {
        // Arrange
        recipe.setAmtMilk(5);

        // Act
        int amount = recipe.getAmtMilk();

        // Assert
        assertEquals(5, amount);
    }

    @Test
    void testGetAmtSugar() {
        // Arrange
        recipe.setAmtSugar(5);

        // Act
        int amount = recipe.getAmtSugar();

        // Assert
        assertEquals(5, amount);
    }

    @Test
    void testGetName() {
        // Arrange
        recipe.setName("Mocha");

        // Act
        String name = recipe.getName();

        // Assert
        assertEquals("Mocha", name);
    }

    @Test
    void testGetPrice() {
        // Arrange
        recipe.setPrice(50);

        // Act
        int price = recipe.getPrice();

        // Assert
        assertEquals(50, price);
    }

    @Test
    void testSetAmtChocolate() {
        // Arrange
        recipe.setAmtChocolate(5);

        // Act
        recipe.setAmtChocolate(-1);

        // Assert
        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffee() {
        // Arrange
        recipe.setAmtCoffee(5);

        // Act
        recipe.setAmtCoffee(-1);

        // Assert
        assertEquals(0, recipe.getAmtCoffee());
    }

    @Test
    void testSetAmtMilk() {
        // Arrange
        recipe.setAmtMilk(5);

        // Act
        recipe.setAmtMilk(-1);

        // Assert
        assertEquals(0, recipe.getAmtMilk());
    }

    @Test
    void testSetAmtSugar() {
        // Arrange
        recipe.setAmtSugar(5);

        // Act
        recipe.setAmtSugar(-1);

        // Assert
        assertEquals(0, recipe.getAmtSugar());
    }

    @Test
    void testSetName() {
        // arrange setUp

        // Act
        recipe.setName("Mocha");

        // Assert
        assertEquals("Mocha", recipe.getName());
    }

    @Test
    void testSetPrice() {
        // Arrange
        recipe.setPrice(50);

        // Act
        recipe.setPrice(-1);

        // Assert
        assertEquals(0, recipe.getPrice());
    }

    @Test
    void testToString() {
        // Arrange
        recipe.setName("Mocha");

        // Act
        String text = recipe.toString();

        // Assert
        assertEquals("Mocha", text);
    }
}
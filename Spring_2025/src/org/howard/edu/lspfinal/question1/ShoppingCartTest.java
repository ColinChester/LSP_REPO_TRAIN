package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }


    @Test
    @DisplayName("Add valid item")
    void addValidItem() {
        cart.addItem("Apple", 1.50);
        assertEquals(1.50, cart.getTotalCost());
    }

    @Test
    @DisplayName("Add negative item")
    void addNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Banana", -0.01), "Adding an item with negative price should throw an exception");
    }

    @Test
    @DisplayName("Add item with zero price")
    void addZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Free", 0.0), "Adding an item with zero price should throw an exception");
    }

    @Test
    @DisplayName("Add item with empty name")
    void addEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 5.00), "Adding an item with an empty name should throw an exception");
    }


    @Test
    @DisplayName("Remove item")
    void removeExistingItem() {
        cart.addItem("A", 2.00);
        cart.addItem("B", 3.00);
        assertEquals(5.00, cart.getTotalCost(), "Price should include both items");

        cart.removeItem("A");
        assertEquals(3.00, cart.getTotalCost(), "Total cost should decrease by $2");
    }

    @Test
    @DisplayName("Remove non-existent item")
    void removeNonExistentItem() {
        cart.addItem("Milk", 4.00);
        assertThrows(IllegalArgumentException.class, () -> cart.removeItem("Bread"), "Removing an item not in the cart should throw an exception");
    }

    
    @Test
    @DisplayName("Cost of empty cart should be zero")
    void totalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), "Empty cart should total to zero");
    }

    @Test
    @DisplayName("Total cost without discount")
    void totalCostWithoutDiscount() {
        cart.addItem("X", 1.00);
        cart.addItem("Y", 2.50);
        cart.addItem("Z", 0.75);
        assertEquals(4.25, cart.getTotalCost(), "Total should be sum of all prices");
    }

    @Test
    @DisplayName("Total cost with SAVE10")
    void totalCostWith10PercentDiscount() {
        cart.addItem("P", 10.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(9.00, cart.getTotalCost(), "10% discount on $10 should be $9");
    }

    @Test
    @DisplayName("Total cost with SAVE20")
    void totalCostWith20PercentDiscount() {
        cart.addItem("P", 50.00);
        cart.addItem("Q", 50.00);
        cart.applyDiscountCode("SAVE20");
        assertEquals(80.00, cart.getTotalCost(), 1e-6, "20% discount on $100 should be $80");
    }


    @Test
    @DisplayName("Discount codes should update discount percentage")
    void applyValidDiscountCodes() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), "SAVE10 should set 10% discount");
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), "SAVE20 should set 20% discount");
    }

    @Test
    @DisplayName("Invalid discount codes")
    void applyInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"), "Invalid code should throw an exception");
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""), "Empty string should throw an exception");
    }


    @Test
    @DisplayName("Cart size reflects adds and removes correctly")
    void cartSizeAfterAddsAndRemoves() {
        assertEquals(0.0, cart.getTotalCost(), "New cart should be empty");

        cart.addItem("A", 1.00);
        cart.addItem("B", 2.00);
        cart.addItem("C", 3.00);
        assertEquals(6.0, cart.getTotalCost(), "There should be $6 in cost after the items are added");

        cart.removeItem("B");
        assertEquals(4.0, cart.getTotalCost(), "Total cost should decrease by $2");

        cart.removeItem("A");
        cart.removeItem("C");
        assertEquals(0, cart.getTotalCost(), "Total cost should be 0 after removing all items");
    }
}

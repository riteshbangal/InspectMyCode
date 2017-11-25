/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.java.exercise.shoppingcart.purchase.Price;
import com.java.exercise.shoppingcart.purchase.ShoppingCart;
import com.java.exercise.shoppingcart.purchase.ShoppingCartImpl;
import com.java.exercise.shoppingcart.purchase.ShoppingItem;

/**
 * DESCRIPTION - This class is responsible to test "Shopping Cart" Solution.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <25-November-2017>
 */
@RunWith(JUnit4.class)
public class ShoppingCartTestCase {
	
	private ShoppingCart shoppingCart = new ShoppingCartImpl();
	ShoppingItem tshirtItem;
	
	@Before
	public void setUp() throws Exception {
		ShoppingItem iphone6Item = new ShoppingItem("apple iphone 6", 1, new Price(60000.00, "INR"));
		tshirtItem = new ShoppingItem("zara t-shirt", 4, new Price(2000.50, "INR"));
		
        shoppingCart.addShoppingCartItem(iphone6Item);
        shoppingCart.addShoppingCartItem(tshirtItem);
	}

	@Test
    public void testCalculateCartPrice() throws CloneNotSupportedException {
		assertEquals("68002.00 INR", shoppingCart.calculateCartPrice().toString());
		
		ShoppingItem iphone5Item = new ShoppingItem("apple iphone 5", 2, new Price(35000.00, "INR"));
		ShoppingItem tshirtExtraItem = new ShoppingItem("zara t-shirt", 5, new Price(2000.50, "INR"));
        
        shoppingCart.addShoppingCartItem(tshirtExtraItem);
        assertEquals("78004.50 INR", shoppingCart.calculateCartPrice().toString());
        
        shoppingCart.removeCartItem(iphone5Item.getProductId());
        shoppingCart.removeCartItem(tshirtItem.getProductId());
        assertEquals("60000.00 INR", shoppingCart.calculateCartPrice().toString());
        
        shoppingCart.addShoppingCartItem(iphone5Item);
        shoppingCart.addShoppingCartItem(tshirtItem);
        assertEquals("138002.00 INR", shoppingCart.calculateCartPrice().toString());
	}
	
	@Test
	public void testClearItems() {
		shoppingCart.clearItems();
		assertEquals(0, shoppingCart.getCartItems().size());
	}
}
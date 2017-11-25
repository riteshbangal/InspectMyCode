/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart;

import org.junit.Assert;
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

	@Test
    public void testCalculateCartPrice() {

		ShoppingItem phoneItem = new ShoppingItem("apple iphone 6", 1, new Price(60000.00, "INR"));
		ShoppingItem tshirtItem = new ShoppingItem("zara t-shirt", 4, new Price(2000.50, "INR"));

        ShoppingCart shoppingCart = new ShoppingCartImpl();

        shoppingCart.addShoppingCartItem(phoneItem);
        shoppingCart.addShoppingCartItem(tshirtItem);

        //Assert.assertEquals("68002.00 INR", shoppingCart.calculateCartPrice());
        Assert.assertEquals("68002.0", String.valueOf(shoppingCart.calculateCartPrice().getSalePrice()));

	}
}
/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart;

import com.java.exercise.shoppingcart.payment.CreditCardStrategy;
import com.java.exercise.shoppingcart.payment.PaymentStrategy;
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
public class RunShoppingCartExercise {

	public static void main(String[] args) throws CloneNotSupportedException {

		ShoppingItem iphone5Item = new ShoppingItem("apple iphone 5", 2, new Price(35000.00, "INR"));
		ShoppingItem iphone6Item = new ShoppingItem("apple iphone 6", 1, new Price(60000.00, "INR"));
		ShoppingItem tshirtItem = new ShoppingItem("zara t-shirt", 4, new Price(2000.50, "INR"));
		ShoppingItem tshirtExtraItem = new ShoppingItem("zara t-shirt", 5, new Price(2000.50, "INR"));

        ShoppingCart shoppingCart = new ShoppingCartImpl();

        shoppingCart.addShoppingCartItem(iphone6Item);
        shoppingCart.addShoppingCartItem(tshirtItem);

        System.out.println(shoppingCart.getCartItems());
        System.out.println(shoppingCart.calculateCartPrice());
        
        shoppingCart.addShoppingCartItem(tshirtExtraItem);

        System.out.println(shoppingCart.getCartItems());
        System.out.println(shoppingCart.calculateCartPrice());
        
        shoppingCart.removeCartItem(iphone5Item.getProductId());
        shoppingCart.removeCartItem(tshirtItem.getProductId());

        System.out.println(shoppingCart.getCartItems());
        System.out.println(shoppingCart.calculateCartPrice());
        
        shoppingCart.addShoppingCartItem(iphone5Item);
        shoppingCart.addShoppingCartItem(tshirtItem);

        System.out.println(shoppingCart.getCartItems());
        System.out.println(shoppingCart.calculateCartPrice());
        
        System.out.println("\nLets checkout and pay the bill..");
        PaymentStrategy paymentMethod = new CreditCardStrategy("Visa", "7845 9090 9754 0101", "100", "20-Jun-2019");
		shoppingCart.pay(paymentMethod);
	}
}
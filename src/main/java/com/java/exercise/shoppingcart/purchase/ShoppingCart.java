/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

import java.util.Set;

import com.java.exercise.shoppingcart.payment.PaymentStrategy;

/**
 * DESCRIPTION - <code>ShoppingCart</code> represents a shopping cart of a <code>Customer</code>.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public interface ShoppingCart {

	/**
	 * Get the cart items in the shopping cart.
	 *
	 * @return the cart items in the shopping cart
	 */
	Set<ShoppingItem> getCartItems();
	
	/**
	 * Add an item to the cart. Update of the quantity will be done if same product is added to the cart.
	 *
	 * @param cartItem the <code>ShoppingItem</code> to add
	 * @return the added cart item
	 */
	ShoppingItem addShoppingCartItem(ShoppingItem cartItem);

	/**
	 * Remove an item from the cart.
	 *
	 * @param cartItem the <code>ShoppingItem</code> to remove
	 */
	void removeCartItem(ShoppingItem cartItem);

	/**
	 * Empties the shopping cart (e.g. after a checkout or remove all items at one shot)
	 */
	void clearItems();
	
	public Price calculateCartPrice();
	
	public void pay(PaymentStrategy paymentMethod);

}
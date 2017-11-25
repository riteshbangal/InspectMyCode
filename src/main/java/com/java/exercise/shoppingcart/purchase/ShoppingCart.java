/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

import java.util.Set;

import com.java.exercise.shoppingcart.payment.PaymentStrategy;

/**
 * DESCRIPTION - ShoppingCart represents a shopping cart of a Customer.
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
	 * @param cartItem the ShoppingItem to add
	 * @return the added cart item
	 * @throws CloneNotSupportedException 
	 */
	ShoppingItem addShoppingCartItem(ShoppingItem cartItem) throws CloneNotSupportedException;

	/**
	 * For time sake considering cartItemId and productId is same. 
	 * Remove an item from the cart for that cartItemId/productId.
	 *
	 * @param cartItemId/productId the ShoppingItem to remove
	 */
	void removeCartItem(String cartItemId);

	/**
	 * Empties the shopping cart (e.g. after a checkout or remove all items at one shot)
	 */
	void clearItems();
	
	/**
	 * Calculate total cart price using visitor design pattern.
	 * 
	 * @return price - the new price (contains Currency)
	 */
	public Price calculateCartPrice();
	
	/**
	 * Shopping Cart has it's corresponding payment method.
	 * Total cart price will be paid using this payment method.
	 * 
	 * @param paymentMethod
	 */
	public void pay(PaymentStrategy paymentMethod);

}
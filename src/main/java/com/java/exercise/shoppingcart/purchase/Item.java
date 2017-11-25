/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

import com.java.exercise.shoppingcart.visitor.Visitable;

/**
 * DESCRIPTION - Represents a quantity, price of Products/SKUs in a shopping-cart/gift-card/wish-list item.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public interface Item extends Visitable<Item>, Cloneable {
	
	/**
	 * Get the product id of this item.
	 * 
	 * @return the product id
	 */
	String getProductId();
	
	/**
	 * Get the quantity of this item.
	 * 
	 * @return the quantity
	 */
	int getQuantity();
	
	/**
	 * Get the price details on the shopping item.
	 * 
	 * @return price - the new price (contains Currency)
	 */
	Price getPrice();
}
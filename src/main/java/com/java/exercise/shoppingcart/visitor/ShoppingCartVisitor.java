/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.visitor;

import com.java.exercise.shoppingcart.purchase.Item;
import com.java.exercise.shoppingcart.purchase.ShoppingItem;

/**
 * DESCRIPTION - This visitor interface and every item will have it’s own logic to calculate the cost.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public class ShoppingCartVisitor implements Visitor<Item> {

	private double result;

    /**
	 * Visit the given ShoppingCart.
	 * 
	 * @param pItem The cart item. Cannot be null.
	 */
	@Override
	public void visit(Item pItem) {
		ShoppingItem shoppingItem = (ShoppingItem) pItem;
		result += shoppingItem.getPrice().getSalePrice() * pItem.getQuantity();
	}

	@Override
	public double getResult() {
		return result;
	}

	/**
     * Resets state of this visitor so its like it has not visited anything yet
     */
	@Override
	public void reset() {
		result = 0;
	}
}
/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

import com.java.exercise.shoppingcart.visitor.Visitor;

/**
 * DESCRIPTION - Represents a quantity, price of Products/SKUs in a shopping cart.
 * 
 * Note - It can contains other attributes, like: item id, last modified date, discount, tax etc.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public class ShoppingItem implements Item {

	private String productId;
	private int quantity;
	private Price price;
	
	public ShoppingItem(String productId, int quantity, Price price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ShoppingItem: {productId=" + productId + ", quantity=" + quantity + ", price=" +  price + "}"; 
	}
	
	@Override
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public Price getPrice() {
		return price;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	@Override
	public void accept(Visitor<Item> pVisitor) {
		pVisitor.visit(this);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

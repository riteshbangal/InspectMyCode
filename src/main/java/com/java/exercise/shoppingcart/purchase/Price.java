/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

/**
 * DESCRIPTION - Represents a price object.
 * 
 * Note: Could be refactored to display UI value.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public class Price {

	double salePrice;
	String currency;

	public Price(double salePrice, String currency) {
		super();
		this.salePrice = salePrice;
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return String.format("%.2f %s", salePrice, currency); 
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}

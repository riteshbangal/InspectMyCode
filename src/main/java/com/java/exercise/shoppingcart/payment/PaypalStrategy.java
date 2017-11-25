/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.payment;

import com.java.exercise.shoppingcart.purchase.Price;

/**
 * DESCRIPTION - Concrete implementation of algorithms for payment using paypal account.
 *
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public class PaypalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;

	public PaypalStrategy(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(Price salePrice) {
		// TODO: paypal payment method has to be implemented
		System.out.println(salePrice + " paid using Paypal.");
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

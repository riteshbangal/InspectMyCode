/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.payment;

import com.java.exercise.shoppingcart.purchase.Price;

/**
 * DESCRIPTION - Interface to follow strategy pattern for payment method.
 *
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public interface PaymentStrategy {

	public void pay(Price salePrice);
}
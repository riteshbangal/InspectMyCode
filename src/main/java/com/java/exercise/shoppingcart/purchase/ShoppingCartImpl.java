/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.shoppingcart.purchase;

import java.util.HashSet;
import java.util.Set;

import com.java.exercise.shoppingcart.payment.PaymentStrategy;
import com.java.exercise.shoppingcart.payment.PaypalStrategy;
import com.java.exercise.shoppingcart.visitor.ShoppingCartVisitor;
import com.java.exercise.shoppingcart.visitor.Visitor;

/**
 * DESCRIPTION - <code>ShoppingCart</code> represents a shopping cart of a <code>Customer</code>.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <24-November-2017>
 */
public class ShoppingCartImpl implements ShoppingCart {

	private final Set<ShoppingItem> items = new HashSet<>();
	private final Visitor<Item> visitor;
	private PaymentStrategy paymentStrategy;

    public ShoppingCartImpl() {
        visitor = new ShoppingCartVisitor();
    }

    public ShoppingCartImpl(Visitor<Item> visitor) {
        this.visitor = visitor;
    }
	
	/**
	 * Get the cart items in the shopping cart.
	 *
	 * @return the cart items in the shopping cart
	 */
	@Override
	public Set<ShoppingItem> getCartItems() {
		return items;
		
	}
	
	/**
	 * Add an item to the cart. Update of the quantity will be done if same product is added to the cart.
	 *
	 * @param cartItem the <code>ShoppingItem</code> to add
	 * @return the added cart item
	 */
	@Override
	public ShoppingItem addShoppingCartItem(ShoppingItem cartItem) {
		if (items.contains(cartItem)) {
			// TODOitems
		}
		items.add(cartItem);
		return cartItem;
	}

	/**
	 * Remove an item from the cart.
	 *
	 * @param cartItem the <code>ShoppingItem</code> to remove
	 */
	@Override
	public void removeCartItem(ShoppingItem cartItem) {
		items.remove(cartItem);
	}

	/**
	 * Empties the shopping cart (e.g. after a checkout or remove all items at one shot)
	 */
	@Override
	public void clearItems() {
		items.clear();
	}
	
	/**
	 * Calculate total cart price using visitor design pattern.
	 * 
	 * @return price - the new price (contains Currency)
	 */
	public Price calculateCartPrice() {
		visitor.reset();
        for (ShoppingItem item : items) {
            item.accept(visitor);
        }
		return new Price(visitor.getResult(), "INR"); // Assuming all items having same currency. 
	}
	
	/**
	 * Shopping Cart has it's corresponding payment method.
	 * Total cart price will be paid using this payment method.
	 * 
	 * @param paymentMethod
	 */
	public void pay(PaymentStrategy paymentMethod) {
		Price totalCartPrice = calculateCartPrice();
		paymentMethod.pay(totalCartPrice);
	}

	public PaymentStrategy getPaymentStrategy() {
		if (null == paymentStrategy) {
			return getDefaultPaymentStrategy();
		}
		return paymentStrategy;
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	private PaymentStrategy getDefaultPaymentStrategy() {
		return new PaypalStrategy("myaccount@paypal.com", "paypal_pwd");
	}
}
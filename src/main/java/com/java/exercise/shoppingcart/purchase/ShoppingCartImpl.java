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
 * DESCRIPTION - ShoppingCart represents a shopping cart of a Customer.
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
	 * @param cartItem the ShoppingItem to add
	 * @return the added cart item
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public ShoppingItem addShoppingCartItem(ShoppingItem cartItem) throws CloneNotSupportedException {
		if (items.stream().anyMatch(item -> cartItem.getProductId().equalsIgnoreCase(item.getProductId()))) {
			ShoppingItem existingItem = items.stream()
					.filter(item -> cartItem.getProductId().equalsIgnoreCase(item.getProductId()))
					.findFirst().orElse(null);
			
			/*
			 * Prototype pattern involves here to create a clone of the existingItem object.
			 * If update is done on existing item, as it's a mutable object
			 * data inconsistency is happening while adding same shopping item next time.
			 * It's still holding updated quantity.
			 */
			ShoppingItem updatedItem = (ShoppingItem) existingItem.clone();
			updatedItem.setQuantity(cartItem.getQuantity() + existingItem.getQuantity());
			items.remove(existingItem);
			items.add(updatedItem);
			System.out.println("Quantity updated for Product: " + existingItem.getProductId());
			return updatedItem;
		} else {
			items.add(cartItem);
		}
		return cartItem;
	}

	/**
	 * For time sake considering cartItemId and productId is same. 
	 * Remove an item from the cart for that cartItemId/productId.
	 *
	 * @param cartItem the ShoppingItem to remove
	 */
	@Override
	public void removeCartItem(String productId) {
		items.stream()
			.filter(item -> item.getProductId().equalsIgnoreCase(productId))
			.findFirst().ifPresent(items::remove);
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
	@Override
	public Price calculateCartPrice() {
		visitor.reset();
		items.stream()
			.forEach(item -> item.accept(visitor));
		return new Price(visitor.getResult(), "INR"); // Assuming all items having same currency and hard-coded to 'INR'
	}
	
	/**
	 * Shopping Cart has it's corresponding payment method.
	 * Total cart price will be paid using this payment method.
	 * 
	 * @param paymentMethod
	 */
	@Override
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
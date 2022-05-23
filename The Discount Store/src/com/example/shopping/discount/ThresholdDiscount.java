package com.example.shopping.discount;

/*
 * To generate discount of $5 for every 200 dollars in cart
 */
public class ThresholdDiscount implements DiscountPolicy {

	@Override
	public double applyDiscount(double totalAmount) {
		
		if (totalAmount < 200) {
			return totalAmount;
		}
		
		int discountFactor = (int) totalAmount / 200;
		double discount = discountFactor * 5;
		return totalAmount - discount; 
	}

}

package com.example.shopping.discount.product;

import com.example.shopping.entity.Item;
import com.example.shopping.entity.ItemType;

/*
 * Class to apply percentage discount on items based on type
 */
public class PromotionPricing extends PricingPolicy {

    private final double priceFactor;

    public PromotionPricing(Item baseItem, int percentPromotion) {
        super(baseItem);
        if (percentPromotion < 0 || percentPromotion > 100 ) {
            throw new IllegalArgumentException("percentPromotion must be in [0,100]");
        }
        this.priceFactor = (100 - percentPromotion) / 100.0;
    }

    @Override
    public double priceForQuantity(int quantity) {
    	// If Phone then don't apply the percentage discount
    	if (super.getType() == ItemType.PHONE) {
    		return super.priceForQuantity(quantity);
    	}
    	
    	// else apply percentage discount
        return (super.priceForQuantity(quantity) * priceFactor);
    }
}

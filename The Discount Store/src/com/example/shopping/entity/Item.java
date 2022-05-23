package com.example.shopping.entity;

/*
 * Interface for all items
 */
public interface Item {
    double getUnitPrice();
    
    double priceForQuantity(int quantity);
    
    String getName();
    
    ItemType getType();
}

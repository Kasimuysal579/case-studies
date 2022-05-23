package com.example.shopping;


import com.example.shopping.discount.DiscountPolicy;
import com.example.shopping.discount.ThresholdDiscount;
import com.example.shopping.entity.Cart;
import com.example.shopping.entity.Item;
import com.example.shopping.entity.ItemType;
import com.example.shopping.entity.Product;
import com.example.shopping.entity.User;
import com.example.shopping.entity.UserType;

class Main {
    public static void main (String[] args)
    {
    	User employee = new User(UserType.GOLD, "Cenk");
        Item groceryItem = new Product("Phone", 2000, ItemType.PHONE);
        Item otherItem = new Product("TV", 6000, ItemType.OTHER);
        DiscountPolicy discountPolicy = new ThresholdDiscount();
        
        Cart cart = new Cart(employee, discountPolicy);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        /*
         *  Total (2000 * 4) + (6000 * 4) = 32000
         *  No discount on phone items = 8000 still
         *  After 30% discount on 4 other items totaling 24000 = 16800
         *  After 620 dollars off due to price over $16800 = 24180
         */
        System.out.println(cart.total());         
    }
}
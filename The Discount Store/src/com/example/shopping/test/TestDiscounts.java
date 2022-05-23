package com.example.shopping.test;

import org.junit.Before;
import org.junit.Test;

import com.example.shopping.discount.DiscountPolicy;
import com.example.shopping.discount.ThresholdDiscount;
import com.example.shopping.entity.Cart;
import com.example.shopping.entity.Item;
import com.example.shopping.entity.ItemType;
import com.example.shopping.entity.Product;
import com.example.shopping.entity.User;
import com.example.shopping.entity.UserType;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

/*
 * Test Cases for no discount policy
 */
public class TestDiscounts {

    private Item phoneItem;
    private Item otherItem;
    private User gold;
    private User affiliate;
    private User simpleUser;
    private User simpleUserWith2Years;
    private DiscountPolicy discountPolicy;

    @Before
    public void setUp() {
    	gold = new User(UserType.GOLD, "Cenk");
    	affiliate = new User(UserType.AFFILIATE, "Mert");
    	simpleUser = new User(UserType.SIMPLE, "Ahmet");
    	simpleUserWith2Years = new User(UserType.SIMPLE, "Ali", LocalDateTime.of(2014, 7, 19, 6, 40, 45));
        phoneItem = new Product("Phone", 20, ItemType.PHONE);
        otherItem = new Product("TV", 222, ItemType.OTHER);
        discountPolicy = new ThresholdDiscount();
    }

    @Test
    public void test_goldWithPhone() {
        Cart cart = new Cart(gold, discountPolicy);
        cart.add(phoneItem, 4);
        // No discount because of phone item
        assertEquals(80, cart.total(), 0.01);
        
    }
   
    @Test
    public void test_goldWithOtherItem() {
        Cart cart = new Cart(gold, discountPolicy);
        cart.add(otherItem, 4);
        /*
         *  30% discount then 5 dollars off of each 200 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 30% discount = 621.6
         *  After 30 dollars off due to price over $600 = 606,6 
         */
        assertEquals(606.6, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithPhone() {
        Cart cart = new Cart(affiliate, discountPolicy);
        cart.add(phoneItem, 4);
        // No discount because of phone item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithOtherItem() {
        Cart cart = new Cart(affiliate, discountPolicy);
        cart.add(otherItem, 4);
        /*
         *  10% discount then 5 dollars off of each 200 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 10% discount = 799.2
         *  After 15 dollars off due to price over $700 = 784,2 
         */
        assertEquals(784.2, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWithPhone() {
        Cart cart = new Cart(simpleUser, discountPolicy);
        cart.add(phoneItem, 4);
        // No discount because of phone item
        assertEquals(80, cart.total(), 0.01);
        
    }
    @Test
    public void test_silverUserWithPhone() {
        Cart cart = new Cart(simpleUser, discountPolicy);
        cart.add(phoneItem, 4);
        // No discount because of phone item
        assertEquals(80, cart.total(), 0.01);
        
    }
    @Test
    public void test_simpleUserWithOtherItem() {
        Cart cart = new Cart(simpleUser, discountPolicy);
        cart.add(otherItem, 4);
        /*
         *  Total 222 * 4 = 888
         *  No percentage discount because user is a customer for less than 2 years
         *  After 20 dollars off due to price over $800 = 868
         */
        assertEquals(868, cart.total(), 0.01);        
    }
    
    @Test
    public void test_simpleUserWith2YearsWithPhone() {
        Cart cart = new Cart(simpleUserWith2Years, discountPolicy);
        cart.add(phoneItem, 4);
        // No discount because of phone item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWith2YearsWithOtherItem() {
        Cart cart = new Cart(simpleUserWith2Years, discountPolicy);
        cart.add(otherItem, 4);
        /*
         *  5% discount then 5 dollars off of each 200 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 5% discount = 843.6
         *  After 20 dollars off due to price over $800 =823.6 
         */
        assertEquals(823.6, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_goldWithPhoneAndOtherItem() {
        Cart cart = new Cart(gold, discountPolicy);
        cart.add(phoneItem, 4);
        cart.add(otherItem, 4);
        /*
         *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on phone items = 968 still
         *  After 30% discount on 4 other items totaling 888 = 701.6
         *  After 15 dollars off due to price over $700 =686.6 
         */
        assertEquals(686.6, cart.total(), 0.01);
        
    }
}

 General Information

The project is based on a basic java program to simulate the retail discounts which uses the following technologies:

* Java 1.8
* JUnit for Unit Tests
* Eclipse to run and test the program
Items represent goods/products that can be placed in the cart.

A cart contains a number of items, and can compute the total price of its contents.

Cart items can either be actual products with a fixed unit price, or products with a pricing policy attached for any dicounts that are calculated based on items and not the overall discount policy of current cart.

DiscountPolicy is used to calculate or apply different discounts based on overall cart value of contents.You can run the program by executing shopping.Main.java file in Eclipse. The program was written based on OOP approaching.

DiscountPolicy and item were created as interface and implemented by ThresholdDiscount product classes.

ItemType and userType enums was created to create constants and to make code readable.

Unit tess are provided that can run by executing shopping.test.TestDiscounts and shopping.test.TestWithoutDiscounts. To get the complete test coverage just run JUnit Tests in IDE.






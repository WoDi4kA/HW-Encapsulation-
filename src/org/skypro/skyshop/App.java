package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.sql.SQLOutput;

public class App {

    public static void main(String[] args) {
        Product milk = new Product("Молоко", 89);
        Product meat = new Product("Мясо", 359);
        Product chicken = new Product("Курица", 419);
        Product orange = new Product("Апельсин", 47);
        Product apple = new Product("Яблоко", 38);
        Product cheese = new Product("Сыр", 189);

        ProductBasket basket = new ProductBasket();

        basket.addProductToBasket(milk);
        basket.addProductToBasket(meat);

        basket.outOfBasket(basket);

        System.out.println(basket.checkForName("Молоко"));
        System.out.println(basket.checkForName("Виноград"));

        basket.cleanBasket();

        basket.addProductToBasket(chicken);
        basket.addProductToBasket(orange);
        basket.addProductToBasket(apple);
        basket.addProductToBasket(cheese);
        basket.addProductToBasket(cheese);
        basket.addProductToBasket(cheese);


        basket.outOfBasket(basket);

        System.out.println(basket.checkForName("Молоко"));
        System.out.println(basket.checkForName("Виноград"));

        basket.cleanBasket();
    }

}

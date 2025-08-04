package org.skypro.skyshop;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        Product milk = new SimpleProduct("Молоко", 89);
        Product meat = new SimpleProduct("Мясо", 359);
        Product chicken = new SimpleProduct("Курица", 419);
        Product orange = new SimpleProduct("Апельсин", 47);
        Product apple = new SimpleProduct("Яблоко", 38);
        Product cheese = new SimpleProduct("Сыр", 189);

        ProductBasket basket = new ProductBasket();

        basket.addProductToBasket(milk);
        basket.addProductToBasket(meat);

        basket.printBasket();

        System.out.println(basket.checkForName("Молоко"));
        System.out.println(basket.checkForName("Виноград"));

        basket.cleanBasket();

        basket.addProductToBasket(chicken);
        basket.addProductToBasket(orange);
        basket.addProductToBasket(apple);
        basket.addProductToBasket(cheese);
        basket.addProductToBasket(cheese);
        basket.addProductToBasket(cheese);


        basket.printBasket();

        System.out.println(basket.checkForName("Молоко"));
        System.out.println(basket.checkForName("Виноград"));

        basket.cleanBasket();

    }

}

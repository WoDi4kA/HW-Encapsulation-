package org.skypro.skyshop;
import org.skypro.skyshop.product.*;

public class App {

    public static void main(String[] args) {
        SimpleProduct milk = new SimpleProduct("Молоко", 89);
        FixPriceProduct meat = new FixPriceProduct("Мясо", 359);
        SimpleProduct chicken = new SimpleProduct("Курица", 419);
        DiscountedProduct orange = new DiscountedProduct("Апельсин", 47, 15);
        SimpleProduct apple = new SimpleProduct("Яблоко", 38);

        ProductBasket basket = new ProductBasket();

        basket.addProductToBasket(milk);
        basket.addProductToBasket(meat);
        basket.addProductToBasket(orange);

        System.out.println(milk.toStringSimple());
        System.out.println(meat.toStringFix());
        System.out.println(orange.toStringDiscount());
        System.out.println(basket.toStringBasket());

    }
}

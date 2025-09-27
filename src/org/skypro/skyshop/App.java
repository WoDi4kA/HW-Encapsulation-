package org.skypro.skyshop;
import org.skypro.skyshop.Search.Article;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.product.*;

import javax.sound.midi.Soundbank;

public class App {

    public static void main(String[] args) {
        SimpleProduct milk = new SimpleProduct("Молоко", 89) {
            @Override
            public String getName() {
                return "";
            }
        };
        FixPriceProduct meat = new FixPriceProduct("Мясо", 359) {
            @Override
            public String getName() {
                return "";
            }
        };
        SimpleProduct chicken = new SimpleProduct("Курица", 419) {
            @Override
            public String getName() {
                return "";
            }
        };
        DiscountedProduct orange = new DiscountedProduct("Апельсин", 47, 15) {
            @Override
            public String getName() {
                return "";
            }
        };
        SimpleProduct apple = new SimpleProduct("Яблоко", 38) {
            @Override
            public String getName() {
                return "";
            }
        };


        try {
            SimpleProduct wrongPineapple = new SimpleProduct("   ", 77) {
                @Override
                public String getName() {
                    return "";
                }
            };
        } catch (IllegalArgumentException e) {
            System.out.println("Продукт без названия");
        }

        try {
            SimpleProduct wrongButter = new SimpleProduct("Масло", 0) {
                @Override
                public String getName() {
                    return "";
                }
            };
        } catch (IllegalArgumentException e) {
            System.out.println("Неверная цена продукта");
        }

        try {
            DiscountedProduct wrongCrackers = new DiscountedProduct("Крекеры", 77, 78) {
                @Override
                public String getName() {
                    return "";
                }
            };
        }catch (IllegalArgumentException e) {
            System.out.println("Неверная скидка на продукт");
        }
        System.out.println();

        ProductBasket basket = new ProductBasket();

        basket.addProductToBasket(milk);
        basket.addProductToBasket(meat);
        basket.addProductToBasket(orange);

        basket.printBasket();

        System.out.println();

        SearchEngine smth = new SearchEngine(3);

        Article article_first = new Article("Say Hello", "Hello mymymymymymy amigo!");
        Article article_second = new Article("U should say hello", "Hello mymymymymymy friend!");
        Article article_third = new Article("U must say hello", "Hello u god dammit!");

        smth.add(article_first);
        smth.add(article_second);
        smth.add(article_third);

        String[] results = smth.search("mymymymymymy");
        for (int i = 0; i < results.length;i ++) {
            System.out.println(results[i]);
        }
    }
}

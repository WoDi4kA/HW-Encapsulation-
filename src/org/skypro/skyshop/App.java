package org.skypro.skyshop;
import org.skypro.skyshop.Search.Article;
import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.product.*;

import javax.sound.midi.Soundbank;
import java.util.Map;

public class App {

    public static void main(String[] args) throws BestResultNotFound {
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
        System.out.println("Удаленный товар - " + basket.removeProductFromBasket(milk.getNameOfProduct()));
        System.out.println();

        System.out.println("Список пуст - " + basket.removeProductFromBasket(null));

        System.out.println();

        SearchEngine smth = new SearchEngine(3);

        Article article_first = new Article("Book about Java", "Book");
        Article article_second = new Article("Textbook about Java", "Textbook");
        Article article_third = new Article("Article about Java", "Article");
        Article article_fourth = new Article("Book about JavaScript", "Book");
        Article article_fifth = new Article("Java for beginners", "Book");

        smth.add(article_first);
        smth.add(article_second);
        smth.add(article_third);
        smth.add(article_fourth);
        smth.add(article_first);

        Map<String, Searchable> results = smth.search("Java");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            String key = entry.getKey();
            Searchable value = entry.getValue();
            System.out.println(value);
        }

        System.out.println();

        String textToMatch = "Java";
        try {
            Searchable bestMatch = smth.getCloserToSearch(textToMatch);
            System.out.println("Ближайшее сходство для '" + textToMatch + "': " + bestMatch.searchTerm());
            System.out.println("Тип: " + bestMatch.getTypeOfContent());
        } catch (BestResultNotFound e) {
            throw new BestResultNotFound();
        }

        String textToException = "";
        try {
            Searchable bestMatch = smth.getCloserToSearch(textToException);
            System.out.println("Ближайшее сходство для '" + textToException + "': " + bestMatch.searchTerm());
            System.out.println("Тип: " + bestMatch.getTypeOfContent());
        } catch (BestResultNotFound e) {
            throw new BestResultNotFound("Нет ближайшего сходства");
        }


    }

}

package org.skypro.skyshop.product;

import java.sql.SQLOutput;
import java.util.*;

import org.skypro.skyshop.product.DiscountedProduct;

import javax.imageio.metadata.IIOInvalidTreeException;

public class ProductBasket {
    private Map<String, List<Product>> array;
    private int productsCount = 0;

    public ProductBasket() {
        this.array = new HashMap<String, List<Product>>();
    }

    public void addProductToBasket(Product product) {
        List<Product> products = array.get(product.getNameOfProduct());

        if (products == null) {
            products = new ArrayList<>();
        }

        products.add(product);

        array.put(product.nameOfProduct, products);

        this.productsCount += 1;
    }

    public List<Product> removeProductFromBasket(String name) {
        List<Product> removedProducts = array.get(name);

        if (removedProducts != null) {
            productsCount = removedProducts.size();
            array.remove(name);
            return removedProducts;
        }

        System.out.println("Товар с именем " + name + " не найден");
        return new ArrayList<>();
    }

    public int wholeCostOfBasket() {
        int countOfPrice = 0;
        Collection<List<Product>> productsList = array.values();
        List<List<Product>> listOfProductsList = new ArrayList<>(productsList);

        for (int i = 0; i < listOfProductsList.size(); i++) {
            List<Product> products = listOfProductsList.get(i);
            for (int j = 0; j < products.size(); j++) {
                Product product = products.get(j);
                countOfPrice += product.getPriceOfProduct();
            }
        }
        return countOfPrice;
    }

    public int countOfSpecials() {
        int count = 0;
        Collection<List<Product>> productsList = array.values();
        List<List<Product>> listOfProductsList = new ArrayList<>(productsList);

        for (int i = 0; i < listOfProductsList.size(); i++) {
            List<Product> products = listOfProductsList.get(i);
            for (int j = 0; j < products.size(); j++) {
                Product product = products.get(j);
                count += product.getPriceOfProduct();
            }
        }
        return count;
    }

    public void printBasket() {
        if (array.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        for (Map.Entry<String, List<Product>> entry : array.entrySet()) {
            String productName = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.println(productName + " (" + products.size() + " шт.)");

            Collection<List<Product>> productsList = array.values();
            List<List<Product>> listOfProductsList = new ArrayList<>(productsList);

            for (int i = 0; i < listOfProductsList.size(); i++) {
                System.out.println(products.toString());
            }
        }
        System.out.println("--------------------");
        System.out.println("Общая стоимость: " + wholeCostOfBasket());
        System.out.println("Спецаильных товаров: " + countOfSpecials());
        System.out.println("Всего товаров: " + productsCount);
    }

    @Override
    public String toString() {
        return "Корзина (товаров: " + productsCount + ", общая стоимость: " + wholeCostOfBasket() + " руб.)";
    }

    public boolean checkForName(String name) {
        return array.containsKey(name);
    }

    public void cleanBasket() {
        array.clear();
        this.productsCount = 0;
        System.out.println("Корзина пуста");
    }



}

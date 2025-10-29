package org.skypro.skyshop.product;

import java.sql.SQLOutput;
import java.util.*;

import org.skypro.skyshop.product.DiscountedProduct;

import javax.imageio.metadata.IIOInvalidTreeException;

public class ProductBasket {
    private LinkedList<Product> array;
    private int productsCount = 0;

    public ProductBasket() {
        this.array = new LinkedList<>();
    }

    public void addProductToBasket(Product product) {
        this.array.add(product);
        this.productsCount += 1;

    }

    public List<Product> removeProductFromBasket(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = array.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getNameOfProduct().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                productsCount -= 1;
            }
            if (product.equals(null)) {
                System.out.println("Список пуст");
            }
        }
        return removedProducts;
    }

    public int wholeCostOfBasket() {
        int countOfPrice = 0;
        for (int i = 0; i < array.size(); i++) {
            Product product = array.get(i);

            if (product != null) {
                countOfPrice += product.getPriceOfProduct();
            }
        }
        return countOfPrice;
    }
    public int countOfSpecials() {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            Product product = array.get(i);

            if (product != null) {
                if (product.isSpecial() == true) {
                    count += 1;
                }
            } else {
                break;
            }
        }
        return count;
    }
    public void printBasket() {
        for (int i = 0; i < array.size(); i++) {
            Product product = array.get(i);

            if (product != null) {
                System.out.println(product.toString());
            } else {
                break;
            }
        }
        System.out.println("Итого: " + wholeCostOfBasket());
        System.out.println("Специальных товаров: " + countOfSpecials());
    }

    @Override
    public String toString() {
        super.toString();
        return "Итого:" + wholeCostOfBasket();
    }

    public boolean checkForName(String name) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Product product = array.get(i);

            if (product != null && product.getNameOfProduct().equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    public void cleanBasket() {
        array.clear();
        this.productsCount = 0;
        System.out.println(array.toString());
    }

}

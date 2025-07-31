package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.awt.desktop.AppReopenedEvent;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ProductBasket {
    private Product[] array;
    private int productsCount = 0;

    public ProductBasket() {
        this.array = new Product[5];
    }

    public void addProductToBasket(Product product) {
        if (this.productsCount > array.length - 1) {
            System.out.print("Корзина переполнена!!!\n");
        } else {
            this.array[productsCount] = product;
            this.productsCount += 1;
        }
    }

    public int wholeCostOfBasket() {
        int countOfPrice = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                countOfPrice += array[i].getPriceOfProduct();
            }
        }
        return countOfPrice;
    }

    public void printBasket() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i].getNameOfProduct() + " : " + array[i].getPriceOfProduct());
            }
        }
        System.out.println("Итого : " + wholeCostOfBasket());
    }

    public boolean checkForName(String name) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getNameOfProduct() == name) {
                flag = true;
            }
        }
        return flag;
    }

    public void cleanBasket() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        this.productsCount = 0;
        System.out.println(Arrays.toString(array));
    }

}

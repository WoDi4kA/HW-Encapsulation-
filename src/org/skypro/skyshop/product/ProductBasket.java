package org.skypro.skyshop.product;

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
                System.out.println(array[i].getNameOfProduct() + " : " + array[i].getPriceOfProduct() + " " +
                        array[i].DiscountProduct.getNameOfProduct() + " : " + array[i].DiscountProduct.getPriceOfProduct() +
                        " (" + "скидка" + ") " + array[i].DiscountProduct.discount + "% " +
                        array[i].FixPriceProduct.getNameOfProduct() + " : " + array[i].FixPriceProduct.getPriceOfProduct() + " " +
                        "Итого : " + wholeCostOfBasket() + " " +
                        "Специальных товаров : ");
            }
        }
        System.out.println("Итого : " + wholeCostOfBasket());
    }

    public boolean checkForName(String name) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getNameOfProduct().equals(name)) {
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

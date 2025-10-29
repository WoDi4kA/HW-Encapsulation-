package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

public class Product implements Searchable {

    protected String nameOfProduct;

    public Product(String nameOfProduct) throws RuntimeException{
        this.nameOfProduct = nameOfProduct;

        if (nameOfProduct.isBlank()) {
            throw new IllegalArgumentException("Продукт без названия");
        }
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getPriceOfProduct() {
        return 0;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameOfProduct;
    }

}

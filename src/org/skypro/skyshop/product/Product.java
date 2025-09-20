package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product implements Searchable {

    protected String nameOfProduct;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public abstract int getPriceOfProduct();

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }


}

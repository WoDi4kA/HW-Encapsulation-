package org.skypro.skyshop.product;

public abstract class Product {

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

    public boolean isSpecial() {
        int coontOfSpecial = 0;
        return true;
    }

}

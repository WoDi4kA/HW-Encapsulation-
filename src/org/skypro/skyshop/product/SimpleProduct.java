package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    protected int priceOfProduct;

    public SimpleProduct(String nameOfProduct, int priceOfProduct) {
        super(nameOfProduct);
        this.priceOfProduct = priceOfProduct;
    }

    public String getNameOfProduct() {
        return super.getNameOfProduct();
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    public String toStringSimple() {
        return getNameOfProduct() + " : " + getPriceOfProduct();
    }

}

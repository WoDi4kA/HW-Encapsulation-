package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    protected int priceOfProduct;

    public SimpleProduct(String nameOfProduct, int priceOfProduct) {
        super(nameOfProduct);
        this.priceOfProduct = priceOfProduct;
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

}

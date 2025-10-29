package org.skypro.skyshop.product;

public abstract class SimpleProduct extends Product{

    protected int priceOfProduct;

    public SimpleProduct(String nameOfProduct, int priceOfProduct) throws RuntimeException {
        super(nameOfProduct);
        this.priceOfProduct = priceOfProduct;

        if (priceOfProduct < 1) {
            throw new IllegalArgumentException("Неверная цена продукта");
        }
    }

    public String getNameOfProduct() {
        return super.getNameOfProduct();
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    public String toString() {
        return getNameOfProduct() + " : " + getPriceOfProduct();
    }

    public boolean isSpecial() {
        return false;
    }

}

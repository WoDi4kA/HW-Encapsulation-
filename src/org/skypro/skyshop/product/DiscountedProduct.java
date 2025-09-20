package org.skypro.skyshop.product;

public abstract class DiscountedProduct extends Product {

    protected int basicPrice;
    protected int discount;

    public DiscountedProduct(String nameOfProduct, int basicPrice, int discount) {
        super(nameOfProduct);
        this.basicPrice = basicPrice;
        this.discount = discount;
    }

    @Override
    public int getPriceOfProduct() {
        return (basicPrice - discount);
    }

    public String getNameOfProduct() {
        return super.getNameOfProduct();
    }

    public int getDiscount() {
        return  discount;
    }

    @Override
    public String toString() {
        super.toString();
        return getNameOfProduct() + " : " + getPriceOfProduct() + " (" + getDiscount() + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}

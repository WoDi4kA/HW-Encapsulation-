package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    protected int basicPrice;
    protected int discount;

    public DiscountedProduct(String nameOfProduct, int basicPrice, int discount) {
        super(nameOfProduct);
        this.basicPrice = getPriceOfProduct();
        this.discount = discount;

    }

    @Override
    public int getPriceOfProduct() {
        return basicPrice - discount;
    }

    public String getNameOfProduct() {
        return super.getNameOfProduct();
    }

    public int getDiscount() {
        return  discount;
    }

    public String toStringDiscount() {
        return getNameOfProduct() + " : " + getPriceOfProduct() + " (" + getDiscount() + ")";
    }

}

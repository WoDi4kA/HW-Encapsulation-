package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    protected int basicPrice;
    protected int discount;

    public DiscountedProduct(String nameOfProduct, int basicPrice, int discount) throws RuntimeException{
        super(nameOfProduct);
        this.basicPrice = basicPrice;
        this.discount = discount;


        if (basicPrice < 1) {
            throw new RuntimeException("Неверная цена продукта со скидкой");
        }
        int percentageOfDiscount = (discount * 100) / basicPrice;
        if (0 > percentageOfDiscount || percentageOfDiscount > 100){
            throw new IllegalArgumentException("Неверный процент скидки");
        }
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

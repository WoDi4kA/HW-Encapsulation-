package org.skypro.skyshop.product;

public abstract class FixPriceProduct extends Product {

    protected static int FIX_PRICE_OF_PRODUCT = 137;

    public FixPriceProduct(String nameOfProduct, int FIX_PRICE_OF_PRODUCT) {
        super(nameOfProduct);
        this.FIX_PRICE_OF_PRODUCT = FIX_PRICE_OF_PRODUCT;
    }

    @Override
    public int getPriceOfProduct() {
        return FIX_PRICE_OF_PRODUCT;
    }

    public String getNameOfProduct() {
        return super.getNameOfProduct();
    }

    @Override
    public String toString() {
        super.toString();
        return getNameOfProduct() + " : Фиксированная цена " + getPriceOfProduct();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}

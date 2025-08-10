package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

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

    public String toStringFix() {
        return getNameOfProduct() + " : Фиксированная цена " + getPriceOfProduct();
    }

}

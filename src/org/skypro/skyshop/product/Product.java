package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Article;
import org.skypro.skyshop.Search.Searchable;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Searchable {

    protected String nameOfProduct;

    public Product(String nameOfProduct) throws RuntimeException{
        this.nameOfProduct = nameOfProduct;

        if (nameOfProduct.isBlank()) {
            throw new IllegalArgumentException("Продукт без названия");
        }
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getPriceOfProduct() {
        return 0;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product someProduct = (Product) o;
        return Objects.equals(this.nameOfProduct, someProduct.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfProduct());
    }

}

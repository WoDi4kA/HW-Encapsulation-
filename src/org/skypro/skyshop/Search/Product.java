package org.skypro.skyshop.Search;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product  implements Searchable {

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

}
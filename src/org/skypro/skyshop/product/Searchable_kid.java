package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Searchable_kid  implements Searchable {

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

}

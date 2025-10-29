package org.skypro.skyshop.Search;

import java.util.Objects;

public interface Searchable {
    String searchTerm();
    String getTypeOfContent();
    String getName();

    default String getStringRepresentation() {
        return getName() + getTypeOfContent();
    }

}

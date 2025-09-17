package org.skypro.skyshop.Search;

public interface Searchable {
    String searchTerm();
    String getTypeOfContent();
    String getName();

    default String getStringRepresentation() {
        return getName() + getTypeOfContent();
    }



}

package org.skypro.skyshop.Search;

import java.util.Comparator;
import java.util.Objects;

public interface Searchable {
    String searchTerm();
    String getTypeOfContent();
    String getName();

    default String getStringRepresentation() {
        return getName() + getTypeOfContent();
    }

    default int compareTo(Searchable other) {
        int nameComparasion = Objects.compare(this.getName(), other.getName(), Comparator.nullsFirst(Comparator.naturalOrder()));
        if (nameComparasion != 0) {
            return nameComparasion;
        }

        return Objects.compare(this.getTypeOfContent(), other.getTypeOfContent(), Comparator.nullsFirst(Comparator.naturalOrder()));
    }



}

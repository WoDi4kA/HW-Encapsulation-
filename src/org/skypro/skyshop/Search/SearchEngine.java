package org.skypro.skyshop.Search;


import java.util.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchableStuff;

    public SearchEngine(int sizeOfMassive) {
        searchableStuff = new HashSet<>();
    }

    private static final Comparator<Searchable> NAME_LENGTH_DESC_THEN_NATURAL =
            (s1, s2) -> {
                String n1 = safeName(s1);
                String n2 = safeName(s2);

                int len1 = n1.length();
                int len2 = n2.length();

                int compareLen = Integer.compare(len2, len1);
                if (compareLen != 0) {
                    return compareLen;
                }
                return n1.compareTo(n2);
            };

    private static String safeName(Searchable s) {
        if (s == null) {
            return null;
        }

        String name = s.getName();
        return name == null ? "" : name;
    }


    public Set<Searchable> search(String text) {
        Set<Searchable> result = new TreeSet<>(NAME_LENGTH_DESC_THEN_NATURAL);

        if (text == null && text.isEmpty()) {
            return result;
        }

        String searchLower = text.toLowerCase();
        for (Searchable searchable : searchableStuff) {
            if (searchable == null) continue;
            String searchTerm = searchable.searchTerm();
            if (searchTerm != null && searchTerm.toLowerCase().contains(searchLower)) {
                result.add(searchable);
            }
        }
        return result;
    }

    public void add(Searchable text) {
        searchableStuff.add(text);
    }

    public Searchable getCloserToSearch(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound();
        }

        Searchable closerSearch = null;
        int maxCount = -1;
        String searchlower = search.toLowerCase();

        for (Searchable searchable : searchableStuff) {
            if (searchable == null) continue;
            String searchTerm = searchable.searchTerm();
            if (searchTerm == null) continue;

            String termLower = searchTerm.toLowerCase();
            int count = 0;
            int index = 0;

            while ((index = termLower.indexOf(searchlower, index)) != -1) {
                count += 1;
                index += searchlower.length();
            }

            if (count > maxCount) {
                maxCount = count;
                closerSearch = searchable;
            }
        }
        if (closerSearch == null) {
            throw new BestResultNotFound();
        }

        return closerSearch;
    }
}

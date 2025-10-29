package org.skypro.skyshop.Search;

import java.util.ArrayList;

public class SearchEngine {
    private final ArrayList<Searchable> searchableStuff;

    public SearchEngine(int sizeOfMassive) {
        searchableStuff = new ArrayList<>();
    }

    public String[] search(String text) {
        ArrayList<String> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < searchableStuff.size(); i++) {
            Searchable searchable = searchableStuff.get(i);

            if (text != null && searchable.searchTerm().toLowerCase().contains(text.toLowerCase())) {
                if (count < 5) {
                    result.add(searchable.searchTerm() + " (" + searchable.getTypeOfContent() + ") ");
                    count++;
                } else {
                    break;
                }
            }
        }
        String[] resultArray = new String[result.size()];
        resultArray = result.toArray(resultArray);

        return resultArray;
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

        for (int i = 0; i < searchableStuff.size(); i++) {
            Searchable searchable = searchableStuff.get(i);

            if (searchable != null) {
                String searchTerm = searchable.searchTerm().toLowerCase();
                String searchLower = search.toLowerCase();
                int count = 0;
                int index = 0;

                while ((index = searchTerm.indexOf(searchLower, index)) != -1) {
                    count++;
                    index += searchLower.length();
                }

                if (count > maxCount) {
                    maxCount = count;
                    closerSearch = searchable;
                }
            }
        }

        if (closerSearch == null) {
            throw new BestResultNotFound();
        }

        return closerSearch;
        }


}

package org.skypro.skyshop.Search;

public class SearchEngine {
    private final Searchable[] searchableStuff;
    private int sizeOfMassive;

    public SearchEngine(int sizeOfMassive) {
        searchableStuff = new Searchable[sizeOfMassive];
        sizeOfMassive = 0;
    }

    public String[] search(String text) {
        String[] result = new String[sizeOfMassive];
        int count = 0;

        for (int i = 0; i < searchableStuff.length; i++) {
            if (text != null && searchableStuff[i].searchTerm().toLowerCase().contains(text.toLowerCase())) {
                if (count < 5) {
                    result[count] = searchableStuff[i].searchTerm() + " (" + searchableStuff[i].getTypeOfContent() + ") ";
                    count++;
                } else {
                    break;
                }
            }
        }
        for (int i = count; i < result.length; i++) {
            result[i] = null;
        }
        return result;
    }

    public void add(Searchable text) {
        if (sizeOfMassive < searchableStuff.length) {
            searchableStuff[sizeOfMassive] = text;
            sizeOfMassive++;
        } else {
            System.out.println("Массив полон, добавить нельзя!!!");
        }
    }

    public Searchable getCloserToSearch(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound();
        }

        Searchable closerSearch = null;
        int maxCount = -1;

        for (int i = 0; i < sizeOfMassive; i++) {
            if (searchableStuff[i] != null) {
                String searchTerm = searchableStuff[i].searchTerm().toLowerCase();
                String searchLower = search.toLowerCase();
                int count = 0;
                int index = 0;

                while ((index = searchTerm.indexOf(searchLower, index)) != -1) {
                    count++;
                    index += searchLower.length();
                }

                if (count > maxCount) {
                    maxCount = count;
                    closerSearch = searchableStuff[i];
                }
            }
        }

        if (closerSearch == null) {
            throw new BestResultNotFound();
        }

        return closerSearch;
        }


}

package org.skypro.skyshop.Search;

public class SearchEngine {
    private final Searchable[] searchableStuff;
    private int sizeOfMassive;

    public SearchEngine(int sizeOfMassive) {
        searchableStuff = new Searchable[sizeOfMassive];
        sizeOfMassive = 0;
    }

    public String[] search(String text) {
        String[] result = new String[5];
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

}

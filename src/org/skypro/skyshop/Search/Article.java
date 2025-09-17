package org.skypro.skyshop.Search;

import java.util.Objects;

public final class Article implements Searchable{
    private final String article;
    private final String text;

    public Article(String article, String text) {
        this.article = article;
        this.text = text;
    }


    @Override
    public String toString() {
        return article  + " | " +
                text;
    }

    public String getNameOfArticle() {
        return article;
    }

    public String getNameOfText() {
        return text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return article;
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, text);
    }
}

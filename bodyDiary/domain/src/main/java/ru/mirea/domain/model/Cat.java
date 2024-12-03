package ru.mirea.domain.model;

public class Cat {

    private String url;

    public Cat(String url) {
        this.url = url;
    }
    public String getImageUrl() {
        return url;
    }

    public void setImageUrl(String url) {
        this.url = url;
    }

}

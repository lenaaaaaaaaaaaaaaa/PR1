package ru.mirea.nadezhkinaea.lesson9.domain.models;

public class Movie {

    private int id;
    private String name;

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
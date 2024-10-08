package ru.mirea.nadezhkinaea.bodydiary.domain.models;

public class Parametrs {
    private int id;
    private String name;
    public Parametrs(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

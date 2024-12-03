package ru.mirea.domain.model;

import java.util.List;

public class User {

    private String name;
    private List<Params> params;

    public User(String name, List<Params> params) {
        this.name = name;
        this.params = params;
    }

    public List<Params> getParams() {
        return params;
    }

    public void setParams(List<Params> params) {
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.example;

import java.util.Date;

/**
 * Класс, представляющий подразделение.
 */
public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
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
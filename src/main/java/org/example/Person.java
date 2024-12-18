package org.example;

import java.util.Date;
/**
 * Класс, представляющий человека.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private Date birthDate;

    public Person(int id, String name, String gender, Department department, double salary, Date birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
package org.example;

import java.util.List;

public class printTest {
    public static void main(String[] args) {
        try {
            CsvReader csvReader = new CsvReader();
            List<Person> people = csvReader.readPeopleFromCsv("foreign_names.csv", ';');

            for (Person person : people) {
                System.out.println("ID: " + person.getId());
                System.out.println("Name: " + person.getName());
                System.out.println("Gender: " + person.getGender());
                System.out.println("BirthDate: " + person.getBirthDate());
                System.out.println("Department: " + person.getDepartment().getName());
                System.out.println("Salary: " + person.getSalary());
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

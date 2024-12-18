package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit-тесты для класса CsvReader.
 */
public class CsvReaderTest {

    @Test
    public void testReadPeopleFromCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        List<Person> people = csvReader.readPeopleFromCsv("foreign_names.csv", ';');

        assertNotNull(people);
        assertTrue(people.size() > 0);

        for (Person person : people) {
            assertNotNull(person.getId());
            assertNotNull(person.getName());
            assertNotNull(person.getGender());
            assertNotNull(person.getDepartment());
            assertNotNull(person.getSalary());
            assertNotNull(person.getBirthDate());
        }
    }
}

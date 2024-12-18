package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

/**
 * Класс для чтения данных из CSV файла.
 */
public class CsvReader {

    /**
     * Читает данные из CSV файла и возвращает список объектов Person.
     *
     * @param csvFilePath путь к CSV файлу
     * @param separator   разделитель
     * @return список объектов Person
     * @throws Exception если произошла ошибка при чтении файла
     */
    public List<Person> readPeopleFromCsv(String csvFilePath, char separator) throws Exception {
        List<Person> people = new ArrayList<>();
        int departmentId = 1;

        InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);

        if (in == null) {
            throw new FileNotFoundException("File not found: " + csvFilePath);
        }

        try (InputStreamReader reader = new InputStreamReader(in)) {
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                    .build();

            String[] nextLine;

            csvReader.readNext(); // Пропускаем строку с заголовками

            while ((nextLine = csvReader.readNext()) != null) {
                try {
                    // Проверка на корректность personId
                    if (nextLine[0] == null || nextLine[0].trim().isEmpty()) {
                        System.err.println("Ошибка: personId не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    int personId = Integer.parseInt(nextLine[0]);

                    // Проверка на корректность name
                    if (nextLine[1] == null || nextLine[1].trim().isEmpty()) {
                        System.err.println("Ошибка: name не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    String name = nextLine[1];

                    // Проверка на корректность gender
                    if (nextLine[2] == null || nextLine[2].trim().isEmpty()) {
                        System.err.println("Ошибка: gender не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    String gender = nextLine[2];

                    // Проверка на корректность birthDate
                    if (nextLine[3] == null || nextLine[3].trim().isEmpty()) {
                        System.err.println("Ошибка: birthDate не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    Date birthDate = parseDate(nextLine[3]);

                    // Проверка на корректность categoryCode
                    if (nextLine[4] == null || nextLine[4].trim().isEmpty()) {
                        System.err.println("Ошибка: categoryCode не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    String categoryCode = nextLine[4];

                    // Проверка на корректность salary
                    if (nextLine[5] == null || nextLine[5].trim().isEmpty()) {
                        System.err.println("Ошибка: salary не может быть пустым или null");
                        System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                        continue;
                    }
                    double salary = Double.parseDouble(nextLine[5]);

                    Department department = new Department(departmentId++, categoryCode);
                    Person person = new Person(personId, name, gender, department, salary, birthDate);
                    people.add(person);
                } catch (NumberFormatException | ParseException e) {
                    System.err.println("Ошибка при парсинге данных: " + e.getMessage());
                    System.err.println("Проблемная строка: " + Arrays.toString(nextLine));
                }
            }
        }

        return people;
    }

    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.parse(dateStr);
    }
}

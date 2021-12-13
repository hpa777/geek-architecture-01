package ru.geekbrains;

import ru.geekbrains.abstract_factory.CarFactory;
import ru.geekbrains.abstract_factory.CarFactoryFactory;
import ru.geekbrains.builder.Person;

import java.time.LocalDateTime;

public class Main {

    public static final Main INSTANCE = new Main();

    public static void main(String[] args) {
        CarFactory factory = CarFactoryFactory.createCarFactory("BMW");
        factory.createSedan();

        Person person = Person.createBuilder()
                .withId(1L)
                .withFirstName("Alex")
                .withLastName("Ivanov")
                .withGender("M")
                .withBirthdate(LocalDateTime.now().minusYears(25))
                .withProfession("programmer")
                .withTitle("PhD")
                .build();
    }
}

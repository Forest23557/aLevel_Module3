package com.shulha.builder;

import com.shulha.model.Person;

import java.util.Optional;

public abstract class PersonBuilder<T extends PersonBuilder> implements PersonBuilderInterface {
    private Person person;

    public PersonBuilder(final Person person) {
        this.person = person;
    }

    public abstract T getCertainBuilder();

    @Override
    public PersonBuilderInterface setId(final String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> person.setId(id1));

        return this;
    }

    @Override
    public PersonBuilderInterface setName(final String name) {
        Optional.ofNullable(name)
                .filter(name1 -> !name1.isBlank())
                .ifPresent(name1 -> person.setName(name1));

        return this;
    }

    @Override
    public PersonBuilderInterface setSurname(final String surname) {
        Optional.ofNullable(surname)
                .filter(surname1 -> !surname1.isBlank())
                .ifPresent(surname1 -> person.setSurname(surname1));

        return this;
    }

    @Override
    public PersonBuilderInterface setAge(final int age) {
        if (age > 0 && age < 120) {
            person.setAge(age);
        } else {
            throw new IllegalArgumentException("Person age must be more than 0 and less than 120!");
        }

        return this;
    }

    @Override
    public Person getPerson() {
        return person;
    }
}

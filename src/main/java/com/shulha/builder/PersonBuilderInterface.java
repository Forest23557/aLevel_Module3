package com.shulha.builder;

import com.shulha.model.Person;

public interface PersonBuilderInterface {
    PersonBuilderInterface setId(final String id);

    PersonBuilderInterface setName(final String name);

    PersonBuilderInterface setSurname(final String surname);

    PersonBuilderInterface setAge(final int age);

    Person getPerson();
}

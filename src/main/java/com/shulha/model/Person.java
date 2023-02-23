package com.shulha.model;

import com.shulha.enums.EmploymentTypes;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "person_id")
    private String id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "employment_type")
    private EmploymentTypes employmentType;

    public Person() {
//        this.id = UUID.randomUUID().toString();
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setEmploymentType(final EmploymentTypes employmentType) {
        this.employmentType = employmentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public EmploymentTypes getEmploymentType() {
        return employmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "%s %n" +
                        "ID: %s, %n" +
                        "name: %s, %n" +
                        "surname: %s, %n" +
                        "age: %s, %n",
                employmentType, id, name, surname, age
        );
    }
}

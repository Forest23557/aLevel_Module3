package com.shulha.model;

import com.shulha.enums.EmploymentTypes;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "employment_type")
    private EmploymentTypes employmentType;

    public Person() {
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
}

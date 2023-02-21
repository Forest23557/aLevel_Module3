package com.shulha.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentMarkDTO {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "avg_mark")
    private double averageMark;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(final double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return String.format(
                "name = %s, surname = %s, average mark = %.2f %n",
                name, surname, averageMark
        );
    }
}

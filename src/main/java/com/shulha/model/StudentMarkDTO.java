package com.shulha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class StudentMarkDTO {
    private String name;
    private String surname;
    private double averageMark;

    public StudentMarkDTO() {
    }

    public StudentMarkDTO(final String name, final String surname, final double averageMark) {
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }

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

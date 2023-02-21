package com.shulha.DTO;

import com.shulha.enums.Subjects;
import com.shulha.model.Subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MinMaxMarkDTO {
    @Id
    @Column(name = "subject_name")
    private Subjects subject;
    @Column(name = "avg_mark")
    private double minMaxMark;

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(final Subjects subject) {
        this.subject = subject;
    }

    public double getMinMaxMark() {
        return minMaxMark;
    }

    public void setMinMaxMark(final double minMaxMark) {
        this.minMaxMark = minMaxMark;
    }

    @Override
    public String toString() {
        return String.format(
                "subject = %s, min or max mark = %.2f %n",
                subject, minMaxMark
        );
    }
}

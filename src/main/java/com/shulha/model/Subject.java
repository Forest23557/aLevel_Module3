package com.shulha.model;

import com.shulha.enums.Subjects;

import java.util.Optional;

public class Subject {
    private String id;
    private Subjects subject;

    public Subject() {
        subject = Subjects.NONE;
    }

    public void setSubject(final Subjects subject) {
        this.subject = Optional.ofNullable(subject)
                .orElseGet(() -> Subjects.NONE);
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Subjects getSubject() {
        return subject;
    }

    public String getId() {
        return id;
    }
}

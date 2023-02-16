package com.shulha.model;

import java.util.Optional;

public class Lecturer extends Person {
    private Subject subject;

    public Lecturer() {
    }

    public void setSubject(final Subject subject) {
        this.subject = Optional.ofNullable(subject)
                .orElseGet(() -> new Subject());
    }

    public Subject getSubject() {
        return subject;
    }
}

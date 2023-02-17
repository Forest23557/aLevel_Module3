package com.shulha.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "lecturer")
public class Lecturer extends Person {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @Fetch(FetchMode.JOIN)
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

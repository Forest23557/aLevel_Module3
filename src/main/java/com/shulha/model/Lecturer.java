package com.shulha.model;

import com.shulha.enums.EmploymentTypes;
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
        setEmploymentType(EmploymentTypes.LECTURER);
    }

    public Lecturer(final Subject subject) {
        this.subject = subject;
    }

    public void setSubject(final Subject subject) {
        this.subject = Optional.ofNullable(subject)
                .orElseGet(() -> new Subject());
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(
                        "%s",
                        subject
                );
    }
}

package com.shulha.model;

import com.shulha.enums.Subjects;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "subject_name")
    private Subjects subject;

    public Subject() {
        this(Subjects.NONE);
    }

    public Subject(final Subjects subject) {
//        this.id = UUID.randomUUID().toString();
        this.subject = subject;
    }

    public void setSubject(final Subjects subject) {
        this.subject = subject;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "SUBJECT %n" +
                        "ID: %s, %n" +
                        "name: %s%n",
                id, subject
        );
    }
}

package com.shulha.model;

import com.shulha.enums.Subjects;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Optional;

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

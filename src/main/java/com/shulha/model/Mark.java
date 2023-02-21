package com.shulha.model;

import com.shulha.enums.Subjects;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @Fetch(FetchMode.JOIN)
    private Subject subject;
    @Column(name = "mark_value")
    private int mark;

    public Mark() {
//        this.id = UUID.randomUUID().toString();
    }

    public Mark(final Subject subject, final int mark) {
        this();
        this.subject = Optional.ofNullable(subject)
                .orElseGet(() -> new Subject());
        this.mark = mark;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSubject(final Subject subject) {
        this.subject = Optional.ofNullable(subject)
                .orElseGet(() -> new Subject());
    }

    public void setMark(final int mark) {
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(id, mark.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Mark {%n" +
                        "id = %s, %n" +
                        "%s, %n" +
                        "mark value = %s%n" +
                        "}",
                id, subject, mark
        );
    }
}

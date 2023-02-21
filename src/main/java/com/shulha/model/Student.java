package com.shulha.model;

import com.shulha.enums.EmploymentTypes;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Column(name = "entry_date_time")
    private LocalDateTime entryDateTime;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<Mark> marks;

    public Student() {
        setEmploymentType(EmploymentTypes.STUDENT);
    }

    public void setEntryDateTime(final LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public void setMarks(final List<Mark> marks) {
        this.marks = marks;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(
                        "entry date and time = %s, %n" +
                                "marks = %n" +
                                "%s",
                        entryDateTime.format(DATE_TIME_FORMATTER), marks
                );
    }
}

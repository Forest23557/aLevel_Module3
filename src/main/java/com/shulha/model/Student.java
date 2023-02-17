package com.shulha.model;

import com.shulha.enums.EmploymentTypes;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {
    @Column(name = "entry_date_time")
    private LocalDateTime entryDateTime;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
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
}

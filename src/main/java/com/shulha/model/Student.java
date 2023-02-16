package com.shulha.model;

import com.shulha.enums.EmploymentTypes;

import java.time.LocalDateTime;
import java.util.List;

public class Student extends Person {
    private LocalDateTime entryDateTime;
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

package com.shulha.model;

import com.shulha.enums.Subjects;

import java.util.Optional;

public class Mark {
    private String id;
    private Subject subject;
    private int mark;

    public Mark() {
    }

    public Mark(final Subject subject, final int mark) {
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
}

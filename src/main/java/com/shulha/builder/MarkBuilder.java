package com.shulha.builder;

import com.shulha.model.Mark;
import com.shulha.model.Subject;

import java.util.Objects;
import java.util.Optional;

public class MarkBuilder {
    private Mark mark;

    public MarkBuilder() {
        this.mark = new Mark();
    }

    public MarkBuilder(final Mark mark) {
        this.mark = Optional.ofNullable(mark)
                .orElseGet(Mark::new);
    }

    public MarkBuilder setId(final String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> mark.setId(id1));

        return this;
    }

    public MarkBuilder setSubject(final Subject subject) {
        Optional.ofNullable(subject)
                .ifPresentOrElse(
                        subject1 -> mark.setSubject(subject1),
                        () -> mark.setSubject(new Subject())
                );

        return this;
    }

    public MarkBuilder setMarkValue(final int markValue) {
        if (markValue > 0 && markValue <= 12) {
            mark.setMark(markValue);
        } else {
            throw new IllegalArgumentException("A mark must be more than 0 and less than or equals 12!");
        }

        return this;
    }

    public Mark getMark() {
        return mark;
    }
}

package com.shulha.builder;

import com.shulha.model.Mark;
import com.shulha.model.Subject;

import java.util.Objects;
import java.util.Optional;

public class MarkBuilder implements MarkBuilderInterface {
    private Mark mark;

    public MarkBuilder() {
        this.mark = new Mark();
    }

    @Override
    public MarkBuilderInterface setId(final String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> mark.setId(id1));

        return this;
    }

    @Override
    public MarkBuilderInterface setSubject(final Subject subject) {
        Optional.ofNullable(subject)
                .ifPresentOrElse(
                        subject1 -> mark.setSubject(subject1),
                        () -> mark.setSubject(new Subject())
                );

        return this;
    }

    @Override
    public MarkBuilderInterface setMarkValue(final int markValue) {
        if (markValue > 0 && markValue <= 12) {
            mark.setMark(markValue);
        } else {
            throw new IllegalArgumentException("A mark must be more than 0 and less than or equals 12!");
        }

        return this;
    }

    @Override
    public Mark getMark() {
        return mark;
    }
}

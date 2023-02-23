package com.shulha.builder;

import com.shulha.enums.Subjects;
import com.shulha.model.Subject;

import java.util.Objects;
import java.util.Optional;

public class SubjectBuilder {
    private Subject subject;

    public SubjectBuilder() {
        this.subject = new Subject();
    }

    public SubjectBuilder setId(final String id) {
        Optional.ofNullable(id)
                .filter(id1 -> !id1.isBlank())
                .ifPresent(id1 -> subject.setId(id1));

        return this;
    }

    public SubjectBuilder setSubjectValue(final Subjects subjectValue) {
        Optional.ofNullable(subjectValue)
                .ifPresentOrElse(
                        subj -> subject.setSubject(subj),
                        () -> subject.setSubject(Subjects.NONE)
                );

        return this;
    }

    public Subject getSubject() {
        return subject;
    }
}

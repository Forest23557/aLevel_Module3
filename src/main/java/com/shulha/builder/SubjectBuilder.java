package com.shulha.builder;

import com.shulha.enums.Subjects;
import com.shulha.model.Subject;

public class SubjectBuilder implements SubjectBuilderInterface {
    private Subject subject;

    public SubjectBuilder() {
        this.subject = new Subject();
    }

    // TODO: 2/19/2023 Setup checks
    @Override
    public SubjectBuilderInterface setId(final String id) {
        this.subject.setId(id);
        return this;
    }

    @Override
    public SubjectBuilderInterface setSubjectValue(final Subjects subject) {
        this.subject.setSubject(subject);
        return this;
    }

    @Override
    public Subject getSubject() {
        return subject;
    }
}

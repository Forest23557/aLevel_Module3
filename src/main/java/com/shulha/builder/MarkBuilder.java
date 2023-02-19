package com.shulha.builder;

import com.shulha.model.Mark;
import com.shulha.model.Subject;

public class MarkBuilder implements MarkBuilderInterface {
    private Mark mark;

    public MarkBuilder() {
        this.mark = new Mark();
    }

    // TODO: 2/19/2023 Fill methods and setup checks
    @Override
    public MarkBuilderInterface setId(final String id) {
        return null;
    }

    @Override
    public MarkBuilderInterface setSubject(final Subject subject) {
        return null;
    }

    @Override
    public MarkBuilderInterface setMarkValue(final int markValue) {
        return null;
    }

    @Override
    public Mark getMark() {
        return null;
    }
}

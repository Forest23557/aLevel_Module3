package com.shulha.builder;

import com.shulha.model.Mark;
import com.shulha.model.Subject;

public interface MarkBuilderInterface {
    MarkBuilderInterface setId(final String id);
    MarkBuilderInterface setSubject(final Subject subject);
    MarkBuilderInterface setMarkValue(final int markValue);
    Mark getMark();
}

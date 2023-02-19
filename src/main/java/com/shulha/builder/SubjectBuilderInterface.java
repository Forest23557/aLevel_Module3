package com.shulha.builder;

import com.shulha.enums.Subjects;
import com.shulha.model.Subject;

public interface SubjectBuilderInterface {
    SubjectBuilderInterface setId(final String id);
    SubjectBuilderInterface setSubjectValue(final Subjects subjectValue);
    Subject getSubject();
}

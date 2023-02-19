package com.shulha.service;

import com.shulha.builder.*;
import com.shulha.enums.Subjects;
import com.shulha.model.Lecturer;
import com.shulha.model.Mark;
import com.shulha.model.Person;
import com.shulha.model.Subject;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class UniversityService {
    private static final Random RANDOM = new Random();
    private static UniversityService instance;

    private UniversityService() {
    }

    public static UniversityService getInstance() {
        UniversityService localInstance = instance;

        if (localInstance == null) {
            synchronized (UniversityService.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new UniversityService();
                }
            }
        }

        return instance;
    }

    public Subject getRandomSubject() {
        final int subjectIndex = RANDOM.nextInt(179) + 1;
        final Subjects value = Subjects.values()[subjectIndex];
        final SubjectBuilderInterface subjectBuilder = new SubjectBuilder();

        return subjectBuilder.setSubjectValue(value)
                .getSubject();
    }

    public Mark getRandomMark() {
        final int markValue = RANDOM.nextInt(12) + 1;
        final MarkBuilderInterface markBuilder = new MarkBuilder();

        return markBuilder.setMarkValue(markValue)
                .getMark();
    }

    public Mark getRandomMarkWithRandomSubject() {
        final MarkBuilderInterface markBuilder = new MarkBuilder(getRandomMark());

        return markBuilder
                .setSubject(getRandomSubject())
                .getMark();
    }

    public Person getLecturer() {
        final PersonBuilder<LecturerBuilder> personBuilder = new LecturerBuilder();
        // TODO: 2/20/2023 create name and surname enum
        return personBuilder.getCertainBuilder()
                .setSubject(null)
                .setName("John")
                .setSurname("Doe")
                .setAge(32)
                .getPerson();
    }
}

package com.shulha.service;

import com.shulha.builder.*;
import com.shulha.enums.Groups;
import com.shulha.enums.Names;
import com.shulha.enums.Subjects;
import com.shulha.enums.Surnames;
import com.shulha.model.*;

import java.time.LocalDateTime;
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

    public Person getRandomLecturer() {
        final PersonBuilder<LecturerBuilder> personBuilder = new LecturerBuilder();

        return personBuilder.getCertainBuilder()
                .setSubject(getRandomSubject())
                .setName(getRandomName())
                .setSurname(getRandomSurname())
                .setAge(getRandomAge())
                .getPerson();
    }

    public Person getRandomStudent() {
        final PersonBuilder<StudentBuilder> personBuilder = new StudentBuilder();

        return personBuilder.getCertainBuilder()
                .setEntryDateTime(LocalDateTime.now())
                .setMark(getRandomMarkWithRandomSubject())
                .setName(getRandomName())
                .setSurname(getRandomSurname())
                .setAge(getRandomAge())
                .getPerson();
    }

    public Group getRandomGroup() {
        final GroupBuilderInterface groupBuilder = new GroupBuilder();
        final int studentNumber = RANDOM.nextInt(10) + 1;

        for (int i = 0; i < studentNumber; i++) {
            groupBuilder.setStudent((Student) getRandomStudent());
        }

        return groupBuilder.setGroupValue(getRandomGroupName())
                .getGroup();
    }

    private Groups getRandomGroupName() {
        final int groupIndex = RANDOM.nextInt(81);
        final Groups group = Groups.values()[groupIndex];

        return group;
    }

    private String getRandomName() {
        final int nameIndex = RANDOM.nextInt(40);
        final String name = Names.values()[nameIndex]
                .toString();

        return name;
    }

    private String getRandomSurname() {
        final int surnameIndex = RANDOM.nextInt(34);
        final String surname = Surnames.values()[surnameIndex]
                .toString();

        return surname;
    }

    private int getRandomAge() {
        return RANDOM.nextInt(100) + 16;
    }
}

package com.shulha.service;

import com.shulha.model.GroupMarkDTO;
import com.shulha.model.MinMaxMarkDTO;
import com.shulha.model.StudentGroupDTO;
import com.shulha.model.StudentMarkDTO;
import com.shulha.builder.*;
import com.shulha.enums.Groups;
import com.shulha.enums.Names;
import com.shulha.enums.Subjects;
import com.shulha.enums.Surnames;
import com.shulha.model.*;
import com.shulha.repository.GroupRepository;
import com.shulha.repository.MarkRepository;
import com.shulha.repository.PersonRepository;
import com.shulha.repository.SubjectRepository;

import java.time.LocalDateTime;
import java.util.*;

public class UniversityService {
    private static final Random RANDOM = new Random();
    private final SubjectRepository subjectRepository;
    private final MarkRepository markRepository;
    private final PersonRepository personRepository;
    private final GroupRepository groupRepository;
    private static volatile UniversityService instance;

    private UniversityService() {
        this.subjectRepository = SubjectRepository.getInstance();
        this.markRepository = MarkRepository.getInstance();
        this.personRepository = PersonRepository.getInstance();
        this.groupRepository = GroupRepository.getInstance();
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
        final SubjectBuilder subjectBuilder = new SubjectBuilder();

        return subjectBuilder.setSubjectValue(value)
                .getSubject();
    }

    public Mark getRandomMark() {
        final int markValue = RANDOM.nextInt(12) + 1;
        final MarkBuilder markBuilder = new MarkBuilder();

        return markBuilder.setMarkValue(markValue)
                .getMark();
    }

    public Mark getRandomMarkWithRandomSubject() {
        final MarkBuilder markBuilder = new MarkBuilder(getRandomMark());

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
        final GroupBuilder groupBuilder = new GroupBuilder();
        final int studentNumber = RANDOM.nextInt(10) + 1;

        for (int i = 0; i < studentNumber; i++) {
            groupBuilder.setStudent((Student) getRandomStudent());
        }

        return groupBuilder.setGroupValue(getRandomGroupName())
                .getGroup();
    }

    public void savePerson(final Person person) {
        personRepository.save(person);
    }

    public void createAndSaveRandomStudent() {
        savePerson(getRandomStudent());
    }

    public List<Group> getGroupByName(final String name) {
        Optional<List<Group>> groupList = Optional.ofNullable(null);

        if (Objects.nonNull(name) && !name.isBlank()) {
            groupList = groupRepository.getGroupByName(name);
        }

        return groupList
                .orElseGet(ArrayList::new);
    }

    public List<StudentGroupDTO> getStudentNumberFromGroups() {
        return groupRepository.getStudentNumberInGroups();
    }

    public List<GroupMarkDTO> getAverageMarksFromGroups() {
        return groupRepository.getAverageMarksFromGroups();
    }

    public List<Lecturer> getLecturerByNameOrSurname(final String nameOrSurname) {
        List<Lecturer> lecturers = new ArrayList<>();

        if (Objects.nonNull(nameOrSurname) && !nameOrSurname.isBlank()) {
            final String capitalizedNameOrSurname = nameOrSurname.toUpperCase();
            lecturers = personRepository.getLecturerByNameOrSurname(capitalizedNameOrSurname);
        }

        return lecturers;
    }

    public List<StudentMarkDTO> getStudentsWhoseAverageMarksHigherThan(final int lowerBound) {
        final List<StudentMarkDTO> studentMarkDTOList;

        if (lowerBound < 0 || lowerBound > 11) {
            studentMarkDTOList = new ArrayList<>();
        } else {
            studentMarkDTOList = personRepository.getStudentsWhoseAverageMarksHigherThan(lowerBound);
        }

        return studentMarkDTOList;
    }

    public List<MinMaxMarkDTO> getSubjectsWithTheWorstAndTheBestResults() {
        return subjectRepository.getSubjectsWithTheWorstAndTheBestResults();
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

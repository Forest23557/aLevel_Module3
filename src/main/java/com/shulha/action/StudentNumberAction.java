package com.shulha.action;

import com.shulha.model.StudentGroupDTO;

import java.util.List;

public class StudentNumberAction implements Action {
    @Override
    public void execute() {
        final List<StudentGroupDTO> studentNumberFromGroups = UNIVERSITY_SERVICE.getStudentNumberFromGroups();

        for (StudentGroupDTO groupStudent : studentNumberFromGroups) {
            System.out.printf(
                    "Student number in group %s is %s.%n",
                    groupStudent.getGroupName(), groupStudent.getStudentNumber()
            );
        }
    }
}

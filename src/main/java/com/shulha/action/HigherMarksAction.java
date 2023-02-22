package com.shulha.action;

import com.shulha.DTO.StudentMarkDTO;
import com.shulha.util.UserInput;

import java.util.List;

public class HigherMarksAction implements Action {
    @Override
    public void execute() {
        final int lowerBoundMark = UserInput.getLowerBoundMark("Enter your lower bound for marks (0-11)",
                "Your mark is not correct!");
        final List<StudentMarkDTO> students =
                UNIVERSITY_SERVICE.getStudentsWhoseAverageMarksHigherThan(lowerBoundMark);

        System.out.printf("Students whose marks are higher than %s: %n", lowerBoundMark);

        for (StudentMarkDTO student : students) {
            System.out.printf(
                    "name: %s, %n" +
                            "surname: %s, %n" +
                            "average mark: %.2f %n" +
                            "%n",
                    student.getName(), student.getSurname(), student.getAverageMark()
            );
        }
    }
}

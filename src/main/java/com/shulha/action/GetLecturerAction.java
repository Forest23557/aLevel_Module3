package com.shulha.action;

import com.shulha.model.Lecturer;
import com.shulha.util.UserInput;

import java.util.List;

public class GetLecturerAction implements Action {
    @Override
    public void execute() {
        final String lecturerNameOrSurname = UserInput.getNonNullString("Write lecturer name or surname: ",
                "Your line is empty!");

        final List<Lecturer> lecturers = UNIVERSITY_SERVICE.getLecturerByNameOrSurname(lecturerNameOrSurname);

        System.out.println("Your lecturer(s): ");

        for (Lecturer lecturer : lecturers) {
            System.out.printf(
                    "ID: %s, %n" +
                            "name: %s, %n" +
                            "surname: %s, %n" +
                            "age: %s, %n" +
                            "subject: %s%n" +
                            "%n",
                    lecturer.getId(), lecturer.getName(), lecturer.getSurname(),
                    lecturer.getAge(), lecturer.getSubject().getSubject()
            );
        }
    }
}

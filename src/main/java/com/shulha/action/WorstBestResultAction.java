package com.shulha.action;

import com.shulha.model.MinMaxMarkDTO;

import java.util.List;

public class WorstBestResultAction implements Action {
    @Override
    public void execute() {
        final List<MinMaxMarkDTO> subjects =
                UNIVERSITY_SERVICE.getSubjectsWithTheWorstAndTheBestResults();
        int i = 0;

        for (MinMaxMarkDTO subjectMark : subjects) {
            if (i == 0) {
                System.out.printf(
                        "The subject with the worst result is %s whose average mark is %.2f%n",
                        subjectMark.getSubject(), subjectMark.getMinMaxMark()
                );
            } else {
                System.out.printf(
                        "The subject with the best result is %s whose average mark is %.2f%n",
                        subjectMark.getSubject(), subjectMark.getMinMaxMark()
                );
            }
            i++;
        }
    }
}

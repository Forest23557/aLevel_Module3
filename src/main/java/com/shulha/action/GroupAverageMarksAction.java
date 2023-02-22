package com.shulha.action;

import com.shulha.DTO.GroupMarkDTO;

import java.util.List;

public class GroupAverageMarksAction implements Action {
    @Override
    public void execute() {
        final List<GroupMarkDTO> marksFromGroups = UNIVERSITY_SERVICE.getAverageMarksFromGroups();

        for (GroupMarkDTO groupMark : marksFromGroups) {
            System.out.printf(
                    "The group %s has average mark %s%n",
                    groupMark.getGroupName(), groupMark.getAverageMark()
            );
        }
    }
}

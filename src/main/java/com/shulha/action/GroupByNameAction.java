package com.shulha.action;

import com.shulha.model.Group;
import com.shulha.util.UserInput;

import java.util.List;

public class GroupByNameAction implements Action {
    @Override
    public void execute() {
        final String groupName = UserInput.getNonNullString("Write group name: ", "Your line is empty!");
        final List<Group> groupByName = UNIVERSITY_SERVICE.getGroupByName(groupName);

        System.out.println("Your group(s): ");
        for (Group group : groupByName) {
            System.out.println(group);
        }
    }
}

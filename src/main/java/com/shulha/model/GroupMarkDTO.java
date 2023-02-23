package com.shulha.model;

import com.shulha.enums.Groups;

public class GroupMarkDTO {
    private Groups groupName;
    private double averageMark;

    public GroupMarkDTO() {
    }

    public GroupMarkDTO(final Groups groupName, final double averageMark) {
        this.groupName = groupName;
        this.averageMark = averageMark;
    }

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(final Groups groupName) {
        this.groupName = groupName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(final double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "{" +
                "groupName = " + groupName +
                ", averageMark = " + averageMark +
                "}\n";
    }
}

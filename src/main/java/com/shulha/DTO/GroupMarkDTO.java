package com.shulha.DTO;

import com.shulha.enums.Groups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupMarkDTO {
    @Id
    @Column(name = "group_name")
    private Groups groupName;
    @Column(name = "avg_mark")
    private int averageMark;

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(final Groups groupName) {
        this.groupName = groupName;
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(final int averageMark) {
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

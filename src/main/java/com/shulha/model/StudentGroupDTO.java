package com.shulha.model;

import com.shulha.enums.Groups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;

public class StudentGroupDTO {
    private Groups groupName;
    private long studentNumber;

    public StudentGroupDTO() {
    }

    public StudentGroupDTO(final Groups groupName, final long studentNumber) {
        this.groupName = groupName;
        this.studentNumber = studentNumber;
    }

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(final Groups groupName) {
        this.groupName = groupName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(final long studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "groupName = " + groupName +
                ", studentNumber = " + studentNumber +
                "}\n";
    }
}

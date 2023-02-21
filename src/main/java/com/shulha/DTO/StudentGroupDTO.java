package com.shulha.DTO;

import com.shulha.enums.Groups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentGroupDTO {
    @Id
    @Column(name = "group_name")
    private Groups groupName;
    @Column(name = "student_number")
    private int studentNumber;

    public Groups getGroupName() {
        return groupName;
    }

    public void setGroupName(final Groups groupName) {
        this.groupName = groupName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(final int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "GroupDTO {" +
                "groupName=" + groupName +
                ", studentNumber=" + studentNumber +
                '}';
    }
}

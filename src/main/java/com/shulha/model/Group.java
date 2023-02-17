package com.shulha.model;

import com.shulha.enums.Groups;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "student_group")
public class Group {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "group_name")
    private Groups group;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<Student> students;

    public void setId(final String id) {
        this.id = id;
    }

    public Group() {
        this.group = Groups.NONE;
    }

    public void setGroup(final Groups group) {
        this.group = Optional.ofNullable(group)
                .orElseGet(() -> Groups.NONE);
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public Groups getGroup() {
        return group;
    }

    public List<Student> getStudents() {
        return students;
    }
}

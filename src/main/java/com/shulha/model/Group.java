package com.shulha.model;

import com.shulha.enums.Groups;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "student_group")
public class Group {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "group_id")
    private String id;
    @Column(name = "group_name")
    private Groups group;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<Student> students;

    public Group() {
//        this.id = UUID.randomUUID().toString();
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setGroup(final Groups group) {
        this.group = group;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Group %s: " +
                        "%s, %n" +
                        "students = %n" +
                        "%s",
                id, group, students
        );
    }
}

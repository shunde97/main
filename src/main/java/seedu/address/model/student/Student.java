package seedu.address.model.student;

import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Student in TAble
 * author shunde
 */
public class Student {

    // Identity fields
    private Name name;
    private StudentID studentID;
    private Email email;
    private final Set<Tag> tags = new HashSet<>();


    public Student(Name name, StudentID studentID, Email email, Set<Tag> tags) {
        requireAllNonNull(name, studentID, email);
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.tags.addAll(tags);
    }

    public StudentID getStudentID() {
        return studentID;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    /**
     * Returns true if both students of the same name other identity fields that are the same.
     * This defines a weaker notion of equality between two persons.
     */

    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getName().equals(getName())
                && otherStudent.getStudentID().equals(getStudentID())
                &&  otherStudent.getEmail().equals(getEmail());
    }

    /**
     * Returns true if both students have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getEmail().equals(getEmail())
                && otherStudent.getStudentID().equals(getStudentID());
    }

    @Override
    public String toString() {
        return getName() +
                " Student ID: " +
                getStudentID() +
                " Email: " +
                getEmail() +
                " Tags: " +
                " Remarks ";
    }

}

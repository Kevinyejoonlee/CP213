package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Kevin, 210872060
 * @version 2022-01-17
 */

public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {

	this.id = id;
	this.surname = surname;
	this.forename = forename;
	this.birthDate = birthDate;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "";

	string += "Name:       " + this.surname + ", " + this.forename + "\n";
	string += "ID:         " + this.id + "\n";
	string += "Birthdate:  " + this.birthDate;

	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	result = surname.compareTo(target.surname);
	if (result == 0) {
	    result = forename.compareTo(target.forename);

	    if (result == 0) {
		if (id == target.id) {
		    result = 0;
		} else if (id < target.id) {
		    result = -1;
		} else {
		    result = 1;
		}
	    }
	}

	return result;
    }

    // getters and setters defined here

    /**
     * Setters bellow
     *
     * @param id student ID number
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @param surname student surname
     */
    public void setSurname(String surname) {
	this.surname = surname;
    }

    /**
     * @param forename name of forename
     */
    public void setForename(String forename) {
	this.forename = forename;
    }

    /**
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    /**
     * @return id student ID number
     */
    public int getId() {
	return id;
    }

    /**
     * Getters
     *
     * @return surname student surname
     */
    public String getSurname() {
	return surname;
    }

    /**
     * @return forename name of forename
     */
    public String getForename() {
	return forename;
    }

    /**
     * @return birthDate birthDate in 'YYYY-MM-DD' format
     */
    public LocalDate getBirthDate() {
	return birthDate;
    }

}

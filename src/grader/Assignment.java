package grader;
// Author: William Bowman
// Date: 9/27/2025
// Description: An object that stores information about an assignment. It will store the grade, title, and type

public class Assignment{
    // Variables
    private double grade; // Stores the percent grade of an assignment
    private String title; // Stores the title of an assignment
    private String type; // Stores what type the assignment is(eg. Homework, Quiz, Exam, etc.)

    // The getter functions for each variable
    public double getGrade() {
        return grade;
    } // End of getGrade()

    public String getTitle() {
        return title;
    } // End of getTitle()

    public String getType() {
        return type;
    } // End of getType()

    // The setter functions for each variable
    public void setGrade(double grade) {
        this.grade = grade;
    } // End of setGrade(double)

    public void setTitle(String title) {
        this.title = title;
    } // End of setTitle(String)

    public void setType(String type) {
        this.type = type;
    } // End of setType(String)
} // End of Assignment
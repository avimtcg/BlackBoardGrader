// Author: William Bowman
// Date: 9/27/2025
// Description: This class will read an array of Strings and determine what each assignment's grade and title are
package grader;

public class GradeReader{
    // Constants
    final String STARTOFPAGE = "Skip to main content"; // The skipable elements of the array start with this string
    final String BACKSLASH = "/"; // A backslash element to compare to elements
    final String NOGRADE = "Not graded"; // A not graded string to compare to elements
    final String ONGOING = "Ongoing"; // A ongoing string to compare elements
    final String PAGE = "Page"; // A page string to compare elements
    final String FIRSTPAGELINE = "gradebook.table.unreadIndicator.header"; // A string that the first page has that must be skipped
    final int LINESKIP = 26; // The amount of elements that are skipped over at the top of a page.
    final int PAGESKIP = 4; // The amount of elements that are skipped over at the bottom of a page
    final int ARRAYSIZE = 50; // The amount of Assignments that can fit into the array

    // A function that reads an array of strings
    public Assignment[] readInput(String[] input){
        // Variables
        int index = LINESKIP; // A variable to keep track of the index for the input array
        int assignmentIndex = 0; // The index for the assignents array
        String currentString; // A variable to store the current string
        Assignment[] assignments = new Assignment[ARRAYSIZE]; // An array to hold all the assignments found in the string array
        String assignmentName = "";
        String assignmentScore = "";
        boolean gotAssignmentName = false;
        while (index< input.length){
            if(index==26){
                assignmentName = input[index+1];
                gotAssignmentName = true
            }
            if(gotAssignmentName == true){
                for(int i = index; i< input.length;i++){
                    if(input[i].contains())
                }
            }

        }




        // Reads the file
        while (index < input.length){

        } // End of while loop
        return assignments;
    } // End of readInput(String[])

    public int getAssignment(String[] input, Assignment[] assignments, String currentString, int index, int assignmentIndex){
        // Variables
        Assignment newAssignment = new Assignment(); // A variable to store the title and grade of the object
        boolean keywordFound = false; // A variable to check if a backslash, not graded, or ongoing string is found

        // Sets the title of the assignment
        newAssignment.setTitle(currentString);

        while (!keywordFound || index > input.length){
            index += 1; // Increments the index
            currentString = input[index]; // Gets the current line of the array

            // Checks the currentString to see if it is a keyword
            if (currentString.equals(NOGRADE)){
                index += 1; // Increments the index to the next title
                keywordFound = true;
            } // End of if

            // Puts the percentage grade the user has for a ongoing assignment like attendence
            else if (currentString.equals(ONGOING)){
                index += 1;
                currentString = input[index];
                currentString = currentString.replaceAll("[^0-9]", "");
                newAssignment.setGrade(Double.parseDouble(currentString));
                keywordFound = true;
            } // End of else

            else if (currentString.equals(BACKSLASH)){
                double gradeEarned; // The grade that the assignment earned
                double maxGrade; // The maximum amount of points for a grade

                index -= 1; // Goes to the grade earned and saves it
                currentString = input[index];
                gradeEarned = Double.parseDouble(currentString);

                index += 2; // Goes to maximum points for the grade
                currentString = input[index];
                maxGrade = Double.parseDouble(currentString);

                newAssignment.setGrade(gradeEarned / maxGrade); // Assigns the grade to the assignment variable as a percentage
                keywordFound = true;
            } // End of else if
        }
        assignments[assignmentIndex] = newAssignment; // Adds the new assignment to the array
        return index;
    } // End of getAssignment(String[], String, int, int)
}
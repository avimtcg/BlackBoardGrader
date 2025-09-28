package forms;

import grader.Assignment;
import grader.GradeCalculator;

public class userInputFormPart5 {
    private String[] scorestr = new String[AssignmentData.assignments.length];
    private String[] weightstr = new String[AssignmentData.assignments.length];

    public userInputFormPart5(){
        for(int i =0;i<AssignmentData.assignments.length;i++){
            AssignmentData.assignments[i].setType((String) AssignmentData.assignTypes.get(i).getSelectedItem());
        }
        for(int i = 0;i<AssignmentData.assignments.length;i++){
            String currentType = AssignmentData.assignments[i].getType();
            int weightIndex = 0;
            for(int j = 0;j< AssignmentData.nameFields.size();j++){
                if(currentType.equals(AssignmentData.nameFields.get(j).getText())){
                    weightIndex = j;
                    AssignmentData.assignments[i].setWeight( Double.parseDouble(AssignmentData.percentFields.get(j).getText()) );
                }
            }
        }
        for(int i =0;i<AssignmentData.assignments.length;i++){
            scorestr[i] = Double.toString(AssignmentData.assignments[i].getGrade());
            weightstr[i] = Double.toString(AssignmentData.assignments[i].getWeight());
        }

        GradeCalculator gradeCalculator = new GradeCalculator();

        double finalGrade = gradeCalculator.calculate(scorestr,weightstr);

        System.out.println(finalGrade);




    }
}

package forms;

import grader.Assignment;

public class userInputFormPart5 {
    private String[] scorestr;
    private String[] weightstr;

    public userInputFormPart5(){
        for(int i =0;i<AssignmentData.assignments.length;i++){
            AssignmentData.assignments[i].setType((String) AssignmentData.assignTypes.get(i).getSelectedItem());
        }
        for(int i = 0;i<AssignmentData.assignments.length;i++){
            String currentType = AssignmentData.assignments[i].getType();
            int weightIndex = 0;
            for(int j = 0;i< AssignmentData.nameFields.size();i++){
                if(currentType == AssignmentData.nameFields.get(i).getText()){
                    weightIndex = j;
                    AssignmentData.assignments[i].setWeight( Double.parseDouble(AssignmentData.percentFields.get(j).getText()) );

                }
            }

        }


    }
}

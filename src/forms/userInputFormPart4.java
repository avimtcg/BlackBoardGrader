/*
 * Author: Avi Maniktala
 * Date: 9/27/2025
 * Description:
 */

package forms;

import grader.*;
import interger.IntegerFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

import java.awt.Dimension;

public class userInputFormPart4 extends JFrame{
    private List<JTextField> nameFields;
    private List<JTextField> percentFields;
    private String input;
    private String[] inputArr;
    private Assignment[] assignmentArr;
    private String[] assignTypes = new String[AssignmentData.nameFields.size()];
    private int numAssignments;
    private String[] assignNames;
    private List<JComboBox> typeFields = new ArrayList<>();

    public userInputFormPart4(String input) {
        this.nameFields = AssignmentData.nameFields;
        this.percentFields = AssignmentData.percentFields;

        inputArr = Converter.convert(input);
        GradeReader gradeReader = new GradeReader();
        Assignment[] tempArr = gradeReader.readInput(inputArr);
        assignmentArr = new Assignment[tempArr.length];
        assignmentArr = tempArr;
        numAssignments = assignmentArr.length;
        setTitle("Assignment Types");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        AssignmentData.assignments = new Assignment[numAssignments];
        AssignmentData.assignments = assignmentArr;


        for(int i = 0;i<nameFields.size();i++){
            assignTypes[i] = nameFields.get(i).getText();
        }// converts assignments types to a string array for the combo box

        String title = "";
        for (int i = 0; i<assignmentArr.length;i++) {
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            if (assignmentArr[i] != null) {
                title = assignmentArr[i].getTitle();
                // do stuff with title
            }

            else {
                title = "unnamed assignment " + Integer.toString(i);
            }
            JLabel nameLabel = new JLabel(title);
            nameLabel.setPreferredSize(new Dimension(150, 25));

            JComboBox<String> typeCombo = new JComboBox<>(assignTypes);

            row.add(nameLabel);
            row.add(Box.createHorizontalStrut(20));
            row.add(typeCombo);

            panel.add(row);
            panel.add(Box.createVerticalStrut(5));

            typeFields.add(typeCombo);
        }

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            AssignmentData.assignTypes = new ArrayList<>(typeFields);
            new userInputFormPart5();
            this.dispose();
        });

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        int rowHeight = 40;
        int visibleRows = 5;
        scrollPane.setPreferredSize(new Dimension(400, rowHeight * visibleRows));


        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }
}

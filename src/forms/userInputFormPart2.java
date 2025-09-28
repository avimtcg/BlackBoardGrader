/*
 * Author: Avi Maniktala
 * Date: 9/27/2025
 * Description:
 */

package forms;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.util.*;
import interger.*;
public class userInputFormPart2 extends JFrame {
    private List<JTextField> nameFields = new ArrayList<>();
    private List<JTextField> percentFields = new ArrayList<>();

    public userInputFormPart2(int numAssignments){
        setTitle("Assignment Types");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= numAssignments; i++) {
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

            JTextField nameField = new JTextField(10);
            nameField.setBorder(BorderFactory.createTitledBorder("Assignment " + i + " Name"));

            JTextField percentField = new JTextField(5);
            ((AbstractDocument) percentField.getDocument()).setDocumentFilter(new IntegerFilter());
            percentField.setBorder(BorderFactory.createTitledBorder("% Worth"));

            row.add(nameField);
            row.add(Box.createHorizontalStrut(10));
            row.add(percentField);

            panel.add(row);
            panel.add(Box.createVerticalStrut(5));

            this.nameFields.add(nameField);
            this.percentFields.add(percentField);
        }

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            AssignmentData.nameFields = this.nameFields;
            AssignmentData.percentFields = this.percentFields;
            new userInputFormPart3();
            this.dispose();
        });

        panel.add(nextButton);

        add(new JScrollPane(panel));
        pack();
        setSize(getWidth()+200, getHeight());
        setLocationRelativeTo(null);
        setVisible(true);
    }

}


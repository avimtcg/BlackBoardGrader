/*
* Author: Avi Maniktala
* Date: 9/27/2025
* Description:
 */

package forms;

import javax.swing.*;
import java.util.function.*;

public class userInputFormPart1 extends JFrame{
    private JPanel panel1;
    private JSlider assignmentTypes;
    private JButton nextButton;
    private int numAssignments;
    public userInputFormPart1() {
        setTitle("Input Assignment Types");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        nextButton.addActionListener(e -> {
            numAssignments = assignmentTypes.getValue();
            new userInputFormPart2(numAssignments);
            this.dispose();
        });
    }

    public int getNumAssignments() {
        return numAssignments;
    }
}

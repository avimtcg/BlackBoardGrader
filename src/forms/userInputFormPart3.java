/*
 * Author: Avi Maniktala
 * Date: 9/27/2025
 * Description:
 */

package forms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class userInputFormPart3 extends JFrame{
    private JPanel panel1;
    private JLabel Heading;
    private JPanel imagePanel;
    private JScrollPane scrollPane;
    private JButton nextButton;

    public userInputFormPart3() {
        setTitle("Paste Blackboard Gradebook");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));

        String[] images = {"/images/FirstStep_Instruction.png", "/images/SecondStep_Instruction.png", "/images/ThirdStep_Instruction.png"};



        for (String path : images) {
            java.net.URL url = getClass().getResource(path);
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                Image scaled = icon.getImage().getScaledInstance(800, 480, Image.SCALE_SMOOTH);
                JLabel label = new JLabel(new ImageIcon(scaled));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                imagePanel.add(label);
                imagePanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
        JLabel endLabel = new JLabel("Paste Text here:");
        endLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagePanel.add(endLabel);
        imagePanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JTextArea endTextArea = new JTextArea(5, 30);
        JScrollPane textScroll = new JScrollPane(endTextArea);
        textScroll.setAlignmentX(Component.CENTER_ALIGNMENT); // keeps it centered in BoxLayout
        imagePanel.add(textScroll);

        nextButton.addActionListener(e -> {
            System.out.println(AssignmentData.nameFields.size());
            String input = endTextArea.getText();
            new userInputFormPart4(input);
            this.dispose();

        });


        //can't figure out why I can't scroll without 40-42
        imagePanel.setPreferredSize(new Dimension(1000, images.length * 520));
        imagePanel.revalidate();
        imagePanel.repaint();
        scrollPane.getVerticalScrollBar().setUnitIncrement(40);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}


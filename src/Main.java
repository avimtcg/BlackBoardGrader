//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import forms.*;
public class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        userInputFormPart1 userinputformpart1 = new userInputFormPart1();
                        userinputformpart1.setVisible(true);
                    }
                }
        );
    }
}
package com.emented.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;


public class InputAccuracyFrame extends JFrame {
    private JPanel panel;
    private JTextField accuracyTextField;
    private JButton nextButton;
    private JLabel errorLabel;

    public InputAccuracyFrame() {
        setContentPane(panel);
        setTitle("Input interval");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            try {

                String accuracyText = accuracyTextField.getText();

                if (accuracyText.isBlank()) {
                    errorLabel.setText("Accuracy must not be empty");
                    return;
                }

                double epsilon = Double.parseDouble(accuracyText.replaceAll(",", "."));

                if (epsilon >= 1 || epsilon <= 0) {
                    errorLabel.setText("Accuracy must be greater then 0 and less then 1");
                    throw new NumberFormatException();
                }

                GlobalStore.data.setEpsilon(epsilon);

                ChooseMethodFrame chooseMethodFrame = new ChooseMethodFrame();

                chooseMethodFrame.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                errorLabel.setText("Accuracy must be a floating point number");
            }
        });
    }
}

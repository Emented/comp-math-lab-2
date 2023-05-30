package com.emented.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.BigInterval;

public class InputIntervalFrame extends JFrame {

    private JPanel inputIntervalPanel;
    private JTextField leftField;
    private JTextField rightField;
    private JButton nextButton;
    private JLabel errorLabel;

    public InputIntervalFrame() {
        setContentPane(inputIntervalPanel);
        setTitle("Input interval");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            double left;
            double right;
            try {
                String leftText = leftField.getText();
                String rightText = rightField.getText();

                if (leftText.isBlank()) {
                    errorLabel.setText("Left interval must not be empty");
                    return;
                }

                if (rightText.isBlank()) {
                    errorLabel.setText("Right interval must not be empty");
                    return;
                }

                left = Double.parseDouble(leftText.replaceAll(",", "."));
                right = Double.parseDouble(rightText.replaceAll(",", "."));

                if (left > 100 || left < -100) {
                    errorLabel.setText("Left interval must be a floating point number between -100 and 100");
                    return;
                }

                if (right > 100 || right < -100) {
                    errorLabel.setText("Right interval must be a floating point number between -100 and 100");
                    return;
                }

                if (left >= right) {
                    errorLabel.setText("Right boarder must be greater then left");
                    return;
                }

                GlobalStore.interval = new BigInterval(left, right);

                ListIntervalFrame listIntervalFrame = new ListIntervalFrame();

                listIntervalFrame.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                errorLabel.setText("Borders must be floating point numbers");
            }

        });
    }
}

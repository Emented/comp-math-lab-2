package com.emented.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.BigInterval;

public class InputStartApproximationFrame extends JFrame {
    private JButton nextButton;
    private JLabel errorLabel;
    private JTextField xField;
    private JTextField yField;
    private JPanel panel;

    public InputStartApproximationFrame() {
        setContentPane(panel);
        setTitle("Input start approximations");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            double x;
            double y;
            try {
                String xText = xField.getText();
                String yText = yField.getText();

                if (xText.isBlank()) {
                    errorLabel.setText("X must not be empty");
                    return;
                }

                if (yText.isBlank()) {
                    errorLabel.setText("Y must not be empty");
                    return;
                }

                x = Double.parseDouble(xText.replaceAll(",", "."));
                y = Double.parseDouble(yText.replaceAll(",", "."));

                if (x > 100 || x < -100) {
                    errorLabel.setText("X interval must be a floating point number between -100 and 100");
                    return;
                }

                if (y > 100 || y < -100) {
                    errorLabel.setText("Y interval must be a floating point number between -100 and 100");
                    return;
                }

                GlobalStore.interval = new BigInterval(x, y);

                OutputTypeFrame outputTypeFrame = new OutputTypeFrame();

                outputTypeFrame.setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                errorLabel.setText("Borders must be floating point numbers");
            }

        });
    }
}

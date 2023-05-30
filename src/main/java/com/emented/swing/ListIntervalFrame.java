package com.emented.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.InputData;
import com.emented.math.IntervalCalculator;


public class ListIntervalFrame extends JFrame {
    private JList<InputData> intervalsList;
    private JPanel listIntervalPanel;
    private JButton nextButton;
    private JLabel topLabel;

    public ListIntervalFrame() {
        setContentPane(listIntervalPanel);
        setTitle("Intervals list");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        IntervalCalculator intervalCalculator = new IntervalCalculator();
        GlobalStore.intervals = intervalCalculator.calculateIntervals(GlobalStore.equation, GlobalStore.interval);
        if (GlobalStore.intervals.isEmpty()) {
            topLabel.setText("No answers were found on this interval, try again");

            remove(intervalsList);

            nextButton.addActionListener(e -> {
                if (GlobalStore.isFile) {
                    InputFileFrame inputFileFrame = new InputFileFrame();

                    inputFileFrame.setVisible(true);
                    dispose();
                } else {
                    InputIntervalFrame inputIntervalFrame = new InputIntervalFrame();

                    inputIntervalFrame.setVisible(true);
                    dispose();
                }
            });


        } else {
            intervalsList.setListData(GlobalStore.intervals.toArray(new InputData[0]));

            setVisible(true);


            nextButton.addActionListener(e -> {
                if (GlobalStore.isFile) {
                    double accuracy = GlobalStore.data.getEpsilon();
                    GlobalStore.data = intervalsList.getSelectedValue();
                    GlobalStore.data.setEpsilon(accuracy);
                } else {
                    GlobalStore.data = intervalsList.getSelectedValue();
                }

                if (GlobalStore.isFile) {
                    ChooseMethodFrame chooseMethodFrame = new ChooseMethodFrame();

                    chooseMethodFrame.setVisible(true);
                    dispose();
                } else {
                    InputAccuracyFrame inputAccuracyFrame = new InputAccuracyFrame();

                    inputAccuracyFrame.setVisible(true);
                    dispose();
                }
            });
        }
    }
}

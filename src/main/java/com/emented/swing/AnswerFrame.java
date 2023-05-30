package com.emented.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.emented.data.GlobalStore;
import com.emented.dto.AnswerEquation;
import com.emented.dto.AnswerSystem;
import com.emented.file.FileWorker;
import com.emented.math.NewtonSystemMethod;


public class AnswerFrame extends JFrame {
    private JPanel answerPanel;
    private JTextArea answerArea;

    public AnswerFrame() {
        FileWorker fileWorker = new FileWorker();
        setContentPane(answerPanel);
        setTitle("Answer");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (GlobalStore.isSystem) {
            NewtonSystemMethod newtonSystemMethod = new NewtonSystemMethod();

            try {
                AnswerSystem answerSystem = newtonSystemMethod.solveSystem(GlobalStore.interval, GlobalStore.system);
                answerArea.setText(answerSystem.toString());
                fileWorker.writeAnswerToFile(answerSystem.toString());

                GraphicWorker.showSystem(answerSystem);
            } catch (IllegalArgumentException e) {
                answerArea.setText(e.getMessage());
            }

            if (!GlobalStore.isOutputFile) {
                setVisible(true);
            }
        } else {
            AnswerEquation answer = null;
            String answerString;
            try {
                answer = GlobalStore.method.solveEquation(GlobalStore.equation, GlobalStore.data);
                answerString = answer.toString();
            } catch (IllegalArgumentException e) {
                answerString = e.getMessage();
            }

            answerArea.setText(answerString);
            fileWorker.writeAnswerToFile(answerString);

            if (answer != null) {
                GraphicWorker.showEquation(answer);
            }

            if (!GlobalStore.isOutputFile) {
                setVisible(true);
            }

        }

    }
}

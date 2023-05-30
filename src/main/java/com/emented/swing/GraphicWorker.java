package com.emented.swing;

import java.awt.Color;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.emented.dto.AnswerEquation;
import com.emented.dto.AnswerSystem;
import com.emented.dto.InputData;
import com.emented.system.SystemTask;
import org.math.plot.Plot2DPanel;

public class GraphicWorker {

    public static void showEquation(AnswerEquation answer) {

        Plot2DPanel plot = new Plot2DPanel();

        addEquationOnGraph(plot,
                (Double x) -> answer.getEquation().function(x), answer.getInterval(),
                Color.BLUE);

        JFrame frame = new JFrame("Answer");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(plot);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void showSystem(AnswerSystem answer) {

        Plot2DPanel plot = new Plot2DPanel();

        addSystemOnGraph(plot, answer.getSystem(), new InputData(-5, 5));

        JFrame frame = new JFrame("Answer");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(plot);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void showInitialPlot(BiFunction<Double, Double, Double> function) {

        Plot2DPanel plot = new Plot2DPanel();

        JFrame frame = new JFrame("Initial graph");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(plot);
        frame.setVisible(true);

        double[] x = new double[80];
        double[] y = new double[80];
        double start = -5;
        for (int i = 0; i < 80; i++) {
            x[i] = start;
            y[i] = function.apply(start, 0d);
            start += 0.1;
        }

        plot.addLinePlot("", Color.BLUE, x, y);

        double[] x0 = {-5, 0};
        double[] y0 = {5, 0};
        plot.addLinePlot("y=0", Color.DARK_GRAY, x0, y0);
    }

    private static void addEquationOnGraph(Plot2DPanel plot,
                                           Function<Double, Double> function,
                                           InputData interval,
                                           Color color) {
        double[] x = new double[80];
        double[] y = new double[80];
        double start = interval.getA() - 0.5;

        for (int i = 0; i < 80; i++) {
            x[i] = start;
            y[i] = function.apply(start);
            start += 0.1;
        }

        plot.addLinePlot("", color, x, y);

        double[] x0 = {interval.getA() - 2, 0};
        double[] y0 = {start + 2, 0};
        plot.addLinePlot("y=0", Color.DARK_GRAY, x0, y0);
    }

    private static void addSystemOnGraph(Plot2DPanel plot,
                                         SystemTask system,
                                         InputData interval) {
        addEquationOnGraph(plot, system::firstEquation, interval, Color.RED);
        addEquationOnGraph(plot, system::secondEquation, interval, Color.BLUE);
    }
}

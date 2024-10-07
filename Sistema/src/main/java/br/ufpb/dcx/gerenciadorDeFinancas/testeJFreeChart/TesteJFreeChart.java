package br.ufpb.dcx.gerenciadorDeFinancas.testeJFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class TesteJFreeChart extends JFrame{
    public TesteJFreeChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Scores", "A");
        dataset.addValue(4, "Scores", "B");
        dataset.addValue(3, "Scores", "C");
        dataset.addValue(5, "Scores", "D");

        JFreeChart chart = ChartFactory.createBarChart(
                "Example Chart",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        TesteJFreeChart exemplo = new TesteJFreeChart();

        exemplo.setSize(800, 400);
        exemplo.setLocationRelativeTo(null);
        exemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exemplo.setVisible(true);
    }
}

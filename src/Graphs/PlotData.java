package Graphs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * A program that uses JFreeChart library to plot a line graph
 *
 * @author Brian Otieno Odhiambo
 * @date 12/5/2022
 */
public class PlotData {
    public static void plotLineGraph() throws IOException {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "", "1");
        dataset.addValue(1, "", "3");
        dataset.addValue(2, "", "5");
        dataset.addValue(3, "", "7");
        dataset.addValue(4, "", "9");
        dataset.addValue(5, "", "11");
        dataset.addValue(6, "", "13");

        JFreeChart jFreeChart = ChartFactory.createLineChart("LineGraph", "X-axis", "Y-axis", dataset, PlotOrientation.VERTICAL, false, false, false);

        OutputStream outputStream = new FileOutputStream("C:/Users/localuser/Desktop/plottergraph.png");
        ChartUtils.writeChartAsPNG(outputStream, jFreeChart, 700, 500);
        System.out.println("Successfully published the output！");
    }
    public static void main(String[] args) throws IOException {
        plotLineGraph();
    }
}
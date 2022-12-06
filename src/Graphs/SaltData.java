package Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A program that uses JFreeChart library to plot a salted graph
 *
 * @author Brian Otieno Odhiambo
 * @date 12/5/2022
* */

public class SaltData {
    public static void saltTheGraph() throws IOException {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(-3, "", "0");
        dataset.addValue(5, "", "1");
        dataset.addValue(-1, "", "2");
        dataset.addValue(7, "", "3");
        dataset.addValue(1, "", "4");
        dataset.addValue(9, "", "5");
        dataset.addValue(3, "", "6");

        JFreeChart jFreeChart = ChartFactory.createLineChart("SaltedGraph", "X-axis", "Y-axis", dataset, PlotOrientation.VERTICAL, false, false, false);

        OutputStream outputStream = new FileOutputStream("C:/Users/localuser/Desktop/saltedgraph.png");
        ChartUtils.writeChartAsPNG(outputStream, jFreeChart, 700, 500);
        System.out.println("The output has successfully been published！");
    }

    public static void main(String[] args) throws IOException {
        saltTheGraph();
    }
}

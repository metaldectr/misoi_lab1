package com.romario.misoilab1.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by romario on 9/21/14.
 */
public class RedHistogramPanel extends JPanel implements IHistogram {

	private MyFrame frame;

	private static final int RED_RATE = 16;

	public RedHistogramPanel(MyFrame frame) {
		this.frame = frame;
	}

	@Override
	public JFreeChart generateHistogram(final BufferedImage image) {

		int[] redSamples = new int[COUNT_SAMPLES];
		int maxRedSamples = 0;
		int redValue = 0;

		for(int i = 0; i < redSamples.length; i++) {
			redSamples[i] = 0;
		}

		for(int i = 0; i < image.getWidth(); i++) {
			for(int j = 0; j < image.getHeight(); j++) {
				redValue = 0xff & image.getRGB(i, j) >> RED_RATE;
				redSamples[redValue]++;
				if(redSamples[redValue] > maxRedSamples) {
					maxRedSamples = redSamples[redValue];
				}
			}
		}

		for(int i = 0; i < redSamples.length; i++) {
			redSamples[i] = (int)((redSamples[i] * 255) / maxRedSamples);
		}
		System.out.println(redSamples);

		return createHistogramChart(redSamples);

	}

	public JFreeChart createHistogramChart(final int[] results) {

		IntervalXYDataset dataset = createDataset(results);

		return ChartFactory.createHistogram("RED", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);

	}

	private IntervalXYDataset createDataset(final int[] results) {
		HistogramDataset dataset = new HistogramDataset();

		dataset.addSeries("Red", convertResults(results), 100);

		return dataset;
	}

	private double[] convertResults(final int[] results) {
		double[] res = new double[results.length];
		for(int i = 0; i < results.length; i++) {
			res[i] = results[i];
		}
		return res;
	}

}

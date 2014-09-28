package com.romario.misoilab1.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by romario on 9/21/14.
 */
public class BlueHistogramPanel extends JPanel implements IHistogram {

	private JFrame frame;

	public BlueHistogramPanel(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public JFreeChart generateHistogram(final BufferedImage image) {

		int[] redSamples = new int[COUNT_SAMPLES];
		int maxRedSamples = 0;
		int blueValue = 0;

		for(int i = 0; i < redSamples.length; i++) {
			redSamples[i] = 0;
		}

		for(int i = 0; i < image.getWidth(); i++) {
			for(int j = 0; j < image.getHeight(); j++) {
				blueValue = 0xff & image.getRGB(i, j);
				redSamples[blueValue]++;
				if(redSamples[blueValue] > maxRedSamples) {
					maxRedSamples = redSamples[blueValue];
				}
			}
		}

		for(int i = 0; i < redSamples.length; i++) {
			redSamples[i] = (int)((redSamples[i] * 200) / maxRedSamples);
		}

		return createHistogramChart(redSamples);

	}

	public JFreeChart createHistogramChart(int[] results) {

		IntervalXYDataset dataset = createDataset(results);

		return ChartFactory
				.createHistogram("Blue", "X", "Y", dataset, PlotOrientation.VERTICAL, true, false, false);
	}

	private IntervalXYDataset createDataset(final int[] results) {
		HistogramDataset dataset = new HistogramDataset();

		dataset.addSeries("Blue", convertResults(results) , 400);

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

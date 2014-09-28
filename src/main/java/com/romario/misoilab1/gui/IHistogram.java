package com.romario.misoilab1.gui;

import org.jfree.chart.JFreeChart;

import java.awt.image.BufferedImage;

/**
 * Created by romario on 9/25/14.
 */
public interface IHistogram {

	public static final int COUNT_SAMPLES = 256;

	public JFreeChart generateHistogram(final BufferedImage image);
}

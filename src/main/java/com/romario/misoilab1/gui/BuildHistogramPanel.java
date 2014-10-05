package com.romario.misoilab1.gui;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by romario on 10/5/14.
 */
public class BuildHistogramPanel extends JPanel {

	private JFrame frame;
	private String color;
	private int[] samples = new int[256];

	private static final int RED_PARAMETER = 16;
	private static final int GREEN_PARAMETER = 8;

	public BuildHistogramPanel(JFrame frame) {
		this.frame = frame;
	}

	public BuildHistogramPanel() {

	}

	public void buildHistogramPanel(String color, BufferedImage image) {
		this.color = color;
		int maxSamples = 0;

		if (image != null) {
			for (int i = 0; i < image.getWidth(); i++) {
				for (int j = 0; j < image.getHeight(); j++) {

					int red = (0xff & (image.getRGB(i, j) >> RED_PARAMETER));
					int green = (0xff & (image.getRGB(i, j) >> GREEN_PARAMETER));
					int blue = (0xff & (image.getRGB(i, j)));

					if ("RED".equals(color)) {
						samples[red]++;
						if (samples[red] > maxSamples) {
							maxSamples = samples[red];
						}
					}

					if ("GREEN".equals(color)) {
						samples[green]++;
						if (samples[green] > maxSamples) {
							maxSamples = samples[green];
						}
					}

					if ("BLUE".equals(color)) {
						samples[blue]++;
						if (samples[blue] > maxSamples) {
							maxSamples = samples[blue];
						}
					}
				}
			}

			for (int i = 0; i < samples.length; i++) {
				samples[i] = (int) ((samples[i] * 120) / maxSamples);
			}

		}
	}

	@Override
	public void paintComponent(Graphics g) {

		if ("RED".equals(color)) {
			g.setColor(Color.RED);
		}

		if ("GREEN".equals(color)) {
			g.setColor(Color.GREEN);
		}

		if ("BLUE".equals(color)) {
			g.setColor(Color.BLUE);
		}

		for (int i = 0; i < 255; i++) {
			g.drawLine(i, this.getHeight(), i, this.getHeight() - samples[i]);
		}

	}

	/*private int[] initializeSamples(int[] samples) {
		for (int i = 0; i < samples.length; i++) {
			samples[i] = 0;
		}

		return samples;
	}*/

}

package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;
import com.romario.misoilab1.gui.gbc.GBC;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/21/14.
 */
public class MyViewPanel extends JPanel {

	private MyFrame frame;
	private Form form;
	private Graphics2D graphics2D;
	private GridBagConstraints c = new GridBagConstraints();

	private PicturePanel picturePanel;
	private RedHistogramPanel redHistogramPanel;
	private GreenHistogramPanel greenHistogramPanel;
	private BlueHistogramPanel blueHistogramPanel;

	public MyViewPanel(MyFrame frame) {
		this.frame = frame;
		this.form = frame.getForm();
		setBackground(Color.WHITE);

		redHistogramPanel = new RedHistogramPanel(frame);
		greenHistogramPanel = new GreenHistogramPanel(frame);
		blueHistogramPanel = new BlueHistogramPanel(frame);

		picturePanel = new PicturePanel(frame);

		initializePanels();

	}

	private void initializePanels() {
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 100;
		c.weighty = 100;
		c.gridheight = 3;
		add(picturePanel, c);
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 50;
		c.weighty = 50;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		redHistogramPanel.setBackground(Color.RED);
		add(redHistogramPanel, c);

		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 50;
		c.weighty = 50;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		greenHistogramPanel.setBackground(Color.GREEN);
		add(greenHistogramPanel, c);

		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 50;
		c.weighty = 50;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		blueHistogramPanel.setBackground(Color.BLUE);
		add(blueHistogramPanel, c);


	}

	public void viewCharts() {

		ChartPanel chartPanel = new ChartPanel(redHistogramPanel.generateHistogram(form.getBufferedImage()));
		chartPanel.setSize(300, 200);
		redHistogramPanel.add(chartPanel);


		greenHistogramPanel.add(new ChartPanel(greenHistogramPanel.generateHistogram(form.getBufferedImage())));

		blueHistogramPanel.add(new ChartPanel(blueHistogramPanel.generateHistogram(form.getBufferedImage())));

		/*add(new ChartPanel(redHistogramPanel.generateHistogram(form.getBufferedImage())), c);

		add(new ChartPanel(greenHistogramPanel.generateHistogram(form.getBufferedImage())),c);

		add(new ChartPanel(blueHistogramPanel.generateHistogram(form.getBufferedImage())),c);*/

	}

	public PicturePanel getPicturePanel() {
		return picturePanel;
	}

	public void setPicturePanel(PicturePanel picturePanel) {
		this.picturePanel = picturePanel;
	}

	public RedHistogramPanel getRedHistogramPanel() {
		return redHistogramPanel;
	}

	public void setRedHistogramPanel(RedHistogramPanel redHistogramPanel) {
		this.redHistogramPanel = redHistogramPanel;
	}

	public GreenHistogramPanel getGreenHistogramPanel() {
		return greenHistogramPanel;
	}

	public void setGreenHistogramPanel(GreenHistogramPanel greenHistogramPanel) {
		this.greenHistogramPanel = greenHistogramPanel;
	}

	public BlueHistogramPanel getBlueHistogramPanel() {
		return blueHistogramPanel;
	}

	public void setBlueHistogramPanel(BlueHistogramPanel blueHistogramPanel) {
		this.blueHistogramPanel = blueHistogramPanel;
	}
}

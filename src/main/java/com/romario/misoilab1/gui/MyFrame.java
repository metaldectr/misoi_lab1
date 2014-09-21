package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/20/14.
 */
public final class MyFrame extends JFrame {

	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_WIDTH = 700;

	private MyControlPanel controlPanel;
	private MyPicturePanel picturePanel;

	private Form form = Form.getInstance();

	public MyFrame() {
		setTitle("Misoi Lab1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		MyControlPanel controlPanel = new MyControlPanel(this);
		MyPicturePanel picturePanel = new MyPicturePanel(this);

		RedHistogramPanel redHistogramPanel = new RedHistogramPanel(this);
		GreenHistogramPanel greenHistogramPanel = new GreenHistogramPanel(this);
		BlueHistogramPanel blueHistogramPanel = new BlueHistogramPanel(this);

		this.controlPanel = controlPanel;
		this.picturePanel = picturePanel;

		Container contentPane = getContentPane();

		contentPane.add(controlPanel, BorderLayout.NORTH);
		contentPane.add(picturePanel, BorderLayout.CENTER);
		
		contentPane.add(redHistogramPanel, BorderLayout.EAST);
		contentPane.add(greenHistogramPanel, BorderLayout.EAST);
		contentPane.add(blueHistogramPanel, BorderLayout.EAST);
	}

	public MyControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(MyControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public MyPicturePanel getPicturePanel() {
		return picturePanel;
	}

	public void setPicturePanel(MyPicturePanel picturePanel) {
		this.picturePanel = picturePanel;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

}

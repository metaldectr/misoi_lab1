package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/20/14.
 */
public final class MyFrame extends JFrame {

	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_WIDTH = 700;

	private MyControlPanel controlPanel;
	private MyViewPanel viewPanel;

	private Form form = Form.getInstance();

	public MyFrame() {
		setTitle("Misoi Lab1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		MyControlPanel controlPanel = new MyControlPanel(this);
		MyViewPanel viewPanel = new MyViewPanel(this);

		this.controlPanel = controlPanel;
		this.viewPanel = viewPanel;

		Container contentPane = getContentPane();

		contentPane.add(controlPanel, BorderLayout.NORTH);
		contentPane.add(viewPanel, BorderLayout.CENTER);


	}

	public MyControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(MyControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public MyViewPanel getViewPanel() {
		return viewPanel;
	}

	public void setViewPanel(MyViewPanel viewPanel) {
		this.viewPanel = viewPanel;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

}

package com.romario.misoilab1.gui;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by romario on 10/7/14.
 */
public class PreparationPanel extends JPanel {

  private MyFrame frame;

  private JLabel gMinParam = new JLabel("Gmin:");
  private JFormattedTextField gMinParamTextField = new JFormattedTextField(
      NumberFormat.getNumberInstance());
  private JLabel gMaxParam = new JLabel("Gmax:");
  private JFormattedTextField gMaxParamTextField = new JFormattedTextField(
      NumberFormat.getNumberInstance());
  private JLabel fMinParam = new JLabel("Fmin:");
  private JFormattedTextField fMinParamTextField = new JFormattedTextField(
      NumberFormat.getNumberInstance());
  private JLabel fMaxParam = new JLabel("Fmax:");
  private JFormattedTextField fMaxParamTextField = new JFormattedTextField(
      NumberFormat.getNumberInstance());

	private static final int SIZE_TEXT_FIELD = 3;

	public PreparationPanel() {

		setBackground(Color.LIGHT_GRAY);
	}

	public PreparationPanel(MyFrame frame) {
		this.frame = frame;

		setBackground(Color.LIGHT_GRAY);
		initializeGUI();
	}

	private void initializeGUI() {

		gMinParamTextField.setColumns(SIZE_TEXT_FIELD);
		gMinParamTextField.setText("0");
		gMaxParamTextField.setColumns(SIZE_TEXT_FIELD);
		gMaxParamTextField.setText("255");
		fMinParamTextField.setColumns(SIZE_TEXT_FIELD);
		fMinParamTextField.setText("0");
		fMaxParamTextField.setColumns(SIZE_TEXT_FIELD);
		fMaxParamTextField.setText("255");

		add(gMinParam, BorderLayout.CENTER);
		add(gMinParamTextField, BorderLayout.CENTER);
		add(gMaxParam, BorderLayout.CENTER);
		add(gMaxParamTextField, BorderLayout.CENTER);
		add(fMinParam, BorderLayout.CENTER);
		add(fMinParamTextField, BorderLayout.CENTER);
		add(fMaxParam, BorderLayout.CENTER);
		add(fMaxParamTextField, BorderLayout.CENTER);

	}

	public void setArguments() {
		frame.getForm().setgMin(Integer.parseInt(gMinParamTextField.getText()));
		frame.getForm().setgMax(Integer.parseInt(gMaxParamTextField.getText()));
		frame.getForm().setfMin(Integer.parseInt(fMinParamTextField.getText()));
		frame.getForm().setfMax(Integer.parseInt(fMaxParamTextField.getText()));
	}

}

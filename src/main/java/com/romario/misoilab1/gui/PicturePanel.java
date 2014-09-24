package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/23/14.
 */
public class PicturePanel extends JPanel {

	private MyFrame frame;
	private Form form;
	private Graphics2D graphics2D;

	public PicturePanel(MyFrame frame) {
		this.frame = frame;
		this.form = frame.getForm();
		setBackground(Color.YELLOW);
		setSize(200, 200);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		graphics2D = (Graphics2D) g;

		graphics2D.drawImage(form.getBufferedImage(), null, 100, 100);
	}
}

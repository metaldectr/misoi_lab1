package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/21/14.
 */
public class MyPicturePanel extends JPanel {

	private MyFrame frame;
	private Form form;
	private Graphics2D graphics2D;

	public MyPicturePanel(MyFrame frame) {
		this.frame = frame;
		this.form = frame.getForm();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		graphics2D = (Graphics2D) g;

		graphics2D.drawImage(form.getBufferedImage(), null, 100, 100);
	}

}

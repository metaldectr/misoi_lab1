package com.romario.misoilab1.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/20/14.
 */
public final class MyFrame extends JFrame {

	private static final int DEFAULT_HEIGHT = 500;
	private static final int DEFAULT_WIDTH = 700;

	public MyFrame() {
		setTitle("Misoi Lab1");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		MyPanel panel = new MyPanel(this);
		Container contentPane = getContentPane();
		contentPane.add(panel);
	}

}

package com.romario.misoilab1.main;

import com.romario.misoilab1.gui.MyFrame;

import javax.swing.*;

/**
 * Created by romario on 9/20/14.
 */
public final class Main {
	public static void main(String[] args) {
		System.out.println("start");

		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		System.out.println("finish");
	}
}

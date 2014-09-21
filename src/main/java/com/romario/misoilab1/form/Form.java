package com.romario.misoilab1.form;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Created by romario on 9/21/14.
 */
public class Form implements Serializable {

	private BufferedImage bufferedImage;

	private static Form instance;

	private Form() {

	}

	public static Form getInstance() {
		if (instance == null) {
			instance = new Form();
		}
		return instance;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

}

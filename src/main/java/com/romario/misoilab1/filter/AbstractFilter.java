package com.romario.misoilab1.filter;

import com.romario.misoilab1.form.Form;

import java.awt.image.BufferedImage;

/**
 * Created by romario on 9/20/14.
 */
public abstract class AbstractFilter {

	public abstract BufferedImage convertImage(final Form form);

	public abstract void viewResult(final Form form);
}

package com.romario.misoilab1.filter;

import com.romario.misoilab1.form.Form;
import com.romario.misoilab1.gui.PicturePanel;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by romario on 10/10/14.
 */
public class PreparationFilter extends AbstractFilter {


  @Override
  public BufferedImage convertImage(final Form form) {
    BufferedImage sourceImage =
        ImageConverter.convertRGBImageToBWImage(form.getSourceBufferedImage());
    BufferedImage destinationImage =
        new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(),
            BufferedImage.TYPE_BYTE_GRAY);

    for (int i = 0; i < sourceImage.getWidth(); i++) {
      for (int j = 0; j < sourceImage.getHeight(); j++) {
        int pix = sourceImage.getRGB(i, j);

	      int red = (pix >> 16) & 0xff;
	      int green = (pix >> 8) & 0xff;
	      int blue = pix & 0xff;

	      pix = (red + green + blue) / 3;

        if (pix < form.getfMin()) {
          destinationImage.setRGB(i, j, form.getgMin());
        } else {
          if (pix > form.getfMax()) {
            destinationImage.setRGB(i, j, form.getgMax());
          } else {
	          destinationImage.setRGB(i, j, pix);
          }
        }
      }
    }
    return destinationImage;
  }

  @Override
  public void viewResult(final Form form) {

	  PicturePanel picturePanel = new PicturePanel();
	  picturePanel.repaint();
  }
}

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

	      int checkPix = pix & 0xff;
/*

				pix = ((255 << 16)) | ((255 << 8)) | (255);*/

	      if (checkPix < form.getfMin()) {
          destinationImage.setRGB(i, j, colorValue(form.getgMin()));
        } else {
          if (checkPix > form.getfMax()) {
            destinationImage.setRGB(i, j, colorValue(form.getgMax()));
          } else {
	          destinationImage.setRGB(i, j, colorValue(form.getgMax()));
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

	private int colorValue(int val) {

		return ((val << 16)) | ((val << 8)) | (val);
	}
}

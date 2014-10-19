package com.romario.misoilab1.filter;

import com.romario.misoilab1.form.Form;
import com.romario.misoilab1.gui.PicturePanel;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by romario on 10/14/14.
 */
public class MinMaxFilter extends AbstractFilter {

	private static final String MIN = "MinFilter";
	private static final String MAX = "MaxFilter";
	private static final String MINMAX = "MinMaxFilter";

	private static final int MIN_INDEX = 0;
	private int MAX_INDEX_X;
	private int MAX_INDEX_Y;
	private static final int LENGTH_MATRIX = 3;

	private BufferedImage sourceImage;
	private Form form;

  @Override
  public BufferedImage convertImage(Form form) {

	  this.form = form;
	  sourceImage = form.getSourceBufferedImage();

	  this.MAX_INDEX_X = sourceImage.getWidth();
		this.MAX_INDEX_Y = sourceImage.getHeight();

    BufferedImage destinationImage =
        new BufferedImage(form.getSourceBufferedImage().getWidth(), form.getSourceBufferedImage()
            .getHeight(), BufferedImage.TYPE_INT_RGB);

	  int[][] matrix;
		if (MIN.equals(form.getNameMethod())) {
			destinationImage = handingImageMIN();
		} else {
	    if (MAX.equals(form.getNameMethod())) {
		    destinationImage = handingImageMAX();
	    } else {
		    if (MINMAX.equals(form.getNameMethod())) {
			    sourceImage = handingImageMIN();
			    destinationImage = handingImageMAX();
		    }
	    }
	  }

    return destinationImage;
  }

  @Override
  public void viewResult(Form form) {
	  PicturePanel picturePanel = new PicturePanel();
	  picturePanel.repaint();
  }

	private BufferedImage handingImageMAX() {
		BufferedImage destinationImage =
				new BufferedImage(form.getSourceBufferedImage().getWidth(), form.getSourceBufferedImage()
						.getHeight(), BufferedImage.TYPE_INT_RGB);

		int[][] matrix;

		for (int i = 0; i < sourceImage.getWidth(); i++) {
			for (int j = 0; j < sourceImage.getHeight(); j++) {
				matrix = getMatrix(i, j, sourceImage);
				destinationImage.setRGB(i, j, getMaxValue(matrix));
			}
		}
		return destinationImage;
	}

	private BufferedImage handingImageMIN() {
		BufferedImage destinationImage =
				new BufferedImage(form.getSourceBufferedImage().getWidth(), form.getSourceBufferedImage()
						.getHeight(), BufferedImage.TYPE_INT_RGB);

		int[][] matrix;

		for (int i = 0; i < sourceImage.getWidth(); i++) {
			for (int j = 0; j < sourceImage.getHeight(); j++) {
				matrix = getMatrix(i, j, sourceImage);
				destinationImage.setRGB(i, j, getMinValue(matrix));
			}
		}
		return destinationImage;
	}

	private int[][] getMatrix(int i, int j, BufferedImage image) {
		int[][] matrix = new int[LENGTH_MATRIX][LENGTH_MATRIX];

		int tmpi = i;
		int tmpj = j;

		for (int k = 0; k < LENGTH_MATRIX; k++, i++) {
			for (int l = 0; l < LENGTH_MATRIX; l++, j++) {

				if ( i-1 < MIN_INDEX && j-1 < MIN_INDEX) {
					matrix[k][l] = 0;
					continue;
				} else {
					if (i-1 < MIN_INDEX) {
						matrix[k][l] = 0;
						continue;
					} else {
						if (j-1 < MIN_INDEX) {
							matrix[k][l] = 0;
							continue;
						}
					}
				}

				if (i+1 > MAX_INDEX_Y && j+1 > MAX_INDEX_X) {
					matrix[k][l] = 0;
					continue;
				} else {
					if ( i+1 > MAX_INDEX_Y ) {
						matrix[k][l] = 0;
						continue;
					} else {
						if (j+1 > MAX_INDEX_X) {
							matrix[k][l] = 0;
							continue;
						} else {
							matrix[k][l] = image.getRGB(tmpi-(1-k), tmpj-(1-l));
						}
					}
				}
			}
			j = tmpj;
		}

		return matrix;
	}

	private int getMaxValue(final int[][] matrix) {

		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; i < LENGTH_MATRIX; i++) {
			for (int j = 0; j < LENGTH_MATRIX; j++) {
				if (matrix[i][j] > maxValue) {
					maxValue = matrix[i][j];
				}
			}
		}

		return maxValue;
	}

	private int getMinValue(final int[][] matrix) {

		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < LENGTH_MATRIX; i++) {
			for (int j = 0; j < LENGTH_MATRIX; j++) {
				if (matrix[i][j] < minValue) {
					minValue = matrix[i][j];
				}
			}
		}

		return minValue;
	}

}

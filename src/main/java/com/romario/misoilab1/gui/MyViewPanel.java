package com.romario.misoilab1.gui;

import com.romario.misoilab1.form.Form;
import com.romario.misoilab1.gui.gbc.GBC;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Created by romario on 9/21/14.
 */
public class MyViewPanel extends JPanel {

	private MyFrame frame;
	private Form form;
	private Graphics2D graphics2D;

	private PicturePanel picturePanel;

	public MyViewPanel(MyFrame frame) {
		this.frame = frame;
		this.form = frame.getForm();
		setBackground(Color.WHITE);

		RedHistogramPanel redHistogramPanel = new RedHistogramPanel();
		GreenHistogramPanel greenHistogramPanel = new GreenHistogramPanel();
		BlueHistogramPanel blueHistogramPanel = new BlueHistogramPanel();

		picturePanel = new PicturePanel(frame);
    setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 100;
		c.weighty = 100;
		c.gridheight = 4;
		add(picturePanel, c);

		DefaultPieDataset d =new DefaultPieDataset();
		d.setValue("1", 56);
		JFreeChart j = ChartFactory.createPieChart("L", d, true, true, false);
		JFreeChart j1 = ChartFactory.createPieChart("B", d , true,true,false);
		ChartPanel cp = new ChartPanel(j);
		ChartPanel cp1 = new ChartPanel(j1);
		cp.setSize(50, 50);
		cp1.setSize(50, 50);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 100;
		c.weighty = 100;
		c.gridheight = 1;
		add(cp, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 100;
		c.weighty = 100;
		c.gridheight = 1;
		add(cp1,c);

		/*contentPane.add(redHistogramPanel, new GBC(0, 4).setInsets(4).setAnchor(GridBagConstraints.FIRST_LINE_END));
		contentPane.add(greenHistogramPanel, new GBC(1, 4).setInsets(4).setAnchor(GridBagConstraints.LINE_END));
		contentPane.add(blueHistogramPanel, new GBC(2, 4).setInsets(4).setAnchor(GridBagConstraints.LAST_LINE_END));*/
	}

	public PicturePanel getPicturePanel() {
		return picturePanel;
	}

	public void setPicturePanel(PicturePanel picturePanel) {
		this.picturePanel = picturePanel;
	}
}

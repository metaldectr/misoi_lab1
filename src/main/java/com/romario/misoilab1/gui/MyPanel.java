package com.romario.misoilab1.gui;

import com.romario.misoilab1.factory.FilterAbstractFactory;
import com.romario.misoilab1.factory.TestFilter1Factory;
import com.romario.misoilab1.gui.gbc.GBC;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by romario on 9/20/14.
 */
public final class MyPanel extends JPanel {

	private static final int CELL_INSETS = 4;

	private final JButton openFileButton = new JButton("Choose File");
	private final JButton convertImageButton = new JButton("Convert Image");

	private final JFileChooser fileChooser = new JFileChooser(new File(this.getClass().getClassLoader().getResource("").getPath()));

	private final String[] filters = {"Filter1", "Filter2", "Filter3"};
	private final JComboBox<String> filterComboBox = new JComboBox<String>(filters);

	private final Map<String, FilterAbstractFactory> filtersMap = initializeFilterMap();

	private final MyFrame frame;
	private String item;
	private FilterAbstractFactory currentFilterFactory;


	public MyPanel(MyFrame frame) {

		this.frame = frame;

		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridBagLayout());

		initializeGUI();
		setListeners();

		currentFilterFactory = filtersMap.get("Filter1");
	}

  private void setListeners() {

		openFileButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {

				fileChooser.setFileFilter(new FileFilter() {
					@Override public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						}
						final String name = f.getName();
						return name.endsWith(".jpg") || name.endsWith(".png");

					}

					@Override public String getDescription() {
						return "*.png, *.jpg";
					}
				});
				if (e.getSource() == openFileButton) {
					int returnVal = fileChooser.showOpenDialog(frame);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						System.out.println(file);
					}
				}
			}
		});

    filterComboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        item = (String) filterComboBox.getSelectedItem();
        currentFilterFactory = filtersMap.get(item);
      }
    });

		convertImageButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.out.println(currentFilterFactory.createFilter());
			}
		});

  }

	private void initializeGUI() {
		add(openFileButton, new GBC(0,0).setInsets(MyPanel.CELL_INSETS).setAnchor(GridBagConstraints.WEST));

		add(filterComboBox, new GBC(1,0).setInsets(MyPanel.CELL_INSETS).setAnchor(GridBagConstraints.WEST));

		add(convertImageButton, new GBC(2,1).setInsets(MyPanel.CELL_INSETS).setAnchor(
				GridBagConstraints.WEST));
	}

	private Map<String, FilterAbstractFactory> initializeFilterMap() {
		Map<String, FilterAbstractFactory> currentMap = new HashMap<String, FilterAbstractFactory>();
		currentMap.put("Filter1", TestFilter1Factory.getInstance());

		return currentMap;
	}

}

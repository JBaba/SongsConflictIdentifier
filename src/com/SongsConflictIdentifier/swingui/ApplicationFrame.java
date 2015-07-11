package com.SongsConflictIdentifier.swingui;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationFrame extends JFrame {
	public ApplicationFrame() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnTitle = new JButton("Title");
		btnTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnTitle = new GridBagConstraints();
		gbc_btnTitle.insets = new Insets(0, 0, 0, 5);
		gbc_btnTitle.gridx = 1;
		gbc_btnTitle.gridy = 1;
		getContentPane().add(btnTitle, gbc_btnTitle);
		
		JButton btnArtist = new JButton("Artist");
		GridBagConstraints gbc_btnArtist = new GridBagConstraints();
		gbc_btnArtist.gridx = 2;
		gbc_btnArtist.gridy = 1;
		getContentPane().add(btnArtist, gbc_btnArtist);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4087052381195282745L;

	public static void main(String[] args){
		ApplicationFrame ap = new ApplicationFrame();
		ap.setTitle("Songs Conflict Indetier");
		ap.setVisible(true);
		ap.setSize(500, 500);
		ap.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

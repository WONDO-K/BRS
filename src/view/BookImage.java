package view;


import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.*;

public class BookImage extends JPanel {
	
	// 책 표지 삽입
	
	private Image img;

	public BookImage(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 3, 0, null);
	}
	
}
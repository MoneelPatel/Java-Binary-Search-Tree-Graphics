import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends JFrame 
{
	private Panel panel;
	
	
	public Frame() throws IOException
	{
		super("Binary Search Tree Graphics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		
		Panel jp = new Panel(new BinarySearchTree());
		Insets frameInsets = getInsets();
		
		int frameWidth = jp.getWidth() + (frameInsets.left + frameInsets.right);
		int frameHeight = jp.getHeight() + (frameInsets.top + frameInsets.bottom);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		setLayout(null);
		add(jp);
		pack();
		setVisible(true);
		
	}
	
	public void paint()
	{
		panel.repaint();
	}

	

	
}

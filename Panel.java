import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener
{
	private BinarySearchTree tree;
	private ArrayList<String[]> nodes;
	private final int screenWidth = 1920;
	private final int screenHeight = 1080;
	private Coord[][] lineCoords;
	
	
	public Panel(BinarySearchTree t) throws IOException
	{
		tree = t;
		setSize(1920, 1080);
		t.setAllVals();
		nodes = new ArrayList<String[]>();
		setNodes();
		addMouseListener(this);
		lineCoords = new Coord[nodes.size()][];
		
		for(int i = 0; i < nodes.size(); i++)
		{
			lineCoords[i] = new Coord[nodes.get(i).length];
		}
	}
	
	
	public void setNodes()
	{
		for(int i = 0; i < 7; i++)
		{
			String firstLevel = tree.printLevel(i, tree.getRoot());
			String[] arr = firstLevel.split(",");
			System.out.println(Arrays.toString(arr));
			
			if(allNull(arr))
				break;
			else
				nodes.add(arr);	
		}
	}
	
	
	public static boolean allNull(String[] arr)
	{
		for(String str: arr)
		{
			if(!str.equals("null"))
				return false;
		}
		return true;
	}
	
	//Graphics
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1920, 1080);
		int heightOffset = 100;
		g.setColor(Color.white);
		
		for(int i = 0; i < nodes.size(); i++)
		{
			
			int numNodes = nodes.get(i).length;
			
			int buffer = 1920/numNodes;
			int start = (buffer/2) - 25;
		
			for(int j = 0; j < numNodes; j++)
			{
				placeNodes(g, nodes.get(i)[j], start, heightOffset);
				addLineCoordinate(start + 25, heightOffset + 50, i, j);
				start += buffer;
			}
			
			heightOffset += 100;
		}
		
		printLines(g);
			
	}
	
	
	public void printLines(Graphics g)
	{
		for(int i = 0; i < lineCoords.length; i++)
		{
			for(int j = 0; j < lineCoords[i].length; j++)
			{
				g.setColor(Color.WHITE);
				if(i > 0)
					g.drawLine(lineCoords[i][j].getX(), lineCoords[i][j].getY(), lineCoords[i-1][j/2].getX(), lineCoords[i-1][j/2].getY());
			}
		}
	}
	
	public void addLineCoordinate(int start, int heightOffset, int x, int y)
	{
		lineCoords[x][y] = new Coord(start, heightOffset);
	}
	
	
	public void setBackground(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1920, 1080);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent m) {
		System.out.println("X: " + m.getX() + " Y: " + m.getY());
	}
	
	public void placeNodes(Graphics g, String str, int x, int y)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans", Font.BOLD, 15));
		//x+48, y+65
		g.drawString(str , x + 20, y + 27);
	}
	
}

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchTree 
{
	private BinaryNode tree;
	
	public BinarySearchTree()
	{
		tree = null;
	}
	
	public BinaryNode getRoot()
	{
		return tree;
	}
	
	public void setAllVals() throws IOException
	{
		Scanner input = new Scanner(new File("BSTInput.txt"));
		while(input.hasNext())
		{
			add(input.next());
		}
	}
	
	public void add(Comparable val)
	{
		if(tree == null)
			tree = new BinaryNode(val);
		else
			add(val, tree);
	}
	
	public BinaryNode add(Comparable val, BinaryNode node)
	{	
		if(node == null)
			return new BinaryNode(val);
		
		int compareVal = val.compareTo(node.getValue());
		if(compareVal < 0)
			node.setLeft(add(val, node.getLeft()));
		else if(compareVal >= 0)
			node.setRight(add(val, node.getRight()));
		return node;
	}
	
	public String fullLevelOrder(int lol)
	{
		String str = "";
		for(int i = 0; i < lol; i++)
			str += printLevel(i, tree) +  "\n";
		return str;
	}
	
	public String printLevel(int level, BinaryNode node)
	{
		if(node == null)
		{
			if(level > 0)
				return printLevel(level-1, null) + printLevel(level-1, null);
			return "null,";
		}
		if(level == 0)
			return node.getValue() + ",";
		return printLevel(level-1, node.getLeft()) + printLevel(level-1, node.getRight()); 
		
	}
}

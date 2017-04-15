import java.util.*;

public class avl
{
	class Node 
	{
		int val;
		Node left;
		Node right;

		Node(int key)
		{
			val = key;
			left = null;
			right = null;
		}
	}
	private Node root = null;
	private int height(Node n)
	{
		int h = 0;
		if(n!=null)
		{
			int l_node = height(n.left);
			int r_node = height(n.right);
			int h_maxheight = max(l_node,r_node);
			h = h_maxheight + 1;
		}
		return h;
	}
	private int max(int a,int b)
	{
		int x;
		x = (a > b ? a : b);
		return x;
	}
	private int difference(Node n)
	{
		int l_node = height(n.left);
		int r_node = height(n.right);

		int diff = l_node - r_node;
		return diff;
	}

	public void insert(int val)
	{
		root = insert(val,root);
	}

	private Node insert(int val,Node n)
	{
		if(n == null)
			return new Node(val);
		else if(val > n.val)
		{
			n.right = insert(val,n.right);
			n = balance(n);
		}
		else if(val < n.val)
		{
			n.left = insert(val,n.left);
			n = balance(n);
		}
		return n;
	}

	private Node balance(Node n)
	{
		int d = difference(n);

		if(d > 1)				//right rotation
		{
			if(difference(n.left) > 0)
				n = ll_rotation(n);
			else
				n = lr_rotation(n);
		}

		if(d < -1)				//left rotation
		{
			if(difference(n.right) > 0)
				n = rl_rotation(n);
			else 
				n = rr_rotation(n);
		}
		return n;
	}

	private Node ll_rotation(Node n)
	{
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		return x;
	}

	private Node rr_rotation(Node n)
	{
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		return x;
	}

	private Node lr_rotation(Node n)
	{
		Node x = n.left;
		n.left = rr_rotation(x);
		return ll_rotation(n);
	}

	private Node rl_rotation(Node n)
	{
		Node x = n.right;
		n.right = ll_rotation(x);
		return rr_rotation(n);
	}
	public void display()
	{
		display(root);
	}

	private void display(Node temp)
	{
		if(temp == null)
			return;
		display(temp.left);
		System.out.println(temp.val);
		display(temp.right);
	}
	public static void main(String[] args)
	{
		avl a = new avl();
		a.insert(8);
		a.insert(4);
		a.insert(5);
		a.insert(1);

		a.display();
	}
}

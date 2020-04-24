import java.util.*;

public class BinarySearchTree
{
	static class Node 
	{
		Node left,right;
		int value;
		public Node(int value) 
		{
			this.value = value;
    		}
	}
	static Node ptr=null,nd=null;
	public static void run() 
	{
		Scanner s=new Scanner(System.in);
		int ch,value;
		System.out.print("ENTER NO. OF NODES:");
		int n=s.nextInt();
		System.out.print("ENTER ROOT VALUE:");
		int rt=s.nextInt();
		Node root = new Node(rt);
		System.out.println("Building tree with root value "+root.value);
		System.out.println("ENTER CHILD NODES:");
		for(int i=1;i<n;i++)
			insert(root,s.nextInt());
		do
		{
			System.out.println("\nMENU");
			System.out.println("1.INSERT\n2.DELETE\n3.DISPLAY\n4.EXIT");
			System.out.print("ENTER YOUR CHOICE:");
			ch=s.nextInt();
			switch(ch)
			{
				case 1: System.out.print("ENTER ELEMENT:");
					value=s.nextInt();
					insert(root,value); 
					break;
				case 2: System.out.print("ENTER ELEMENT:");
					value=s.nextInt();
					search(root,value); 
					delete(nd);
					break;
				case 3: System.out.println("INORDER TRAVERSAL");
					inOrder(root);break;
				case 4: System.exit(0);
				default: System.out.println("INVALID CHOICE:");
			}
		}while(ch>=1 && ch<=4);
  	}
  	public static void insert(Node node,int value) 
	{
		if(value < node.value) 
		{
      			if(node.left != null) 
			{
		        	insert(node.left,value);
      			} 
			else 
			{
        			System.out.println("  Inserted " + value + " to left of "+ node.value);
			        node.left = new Node(value);
      			}
    		} 
		else if (value > node.value) 
		{
			if (node.right != null) 
			{
				insert(node.right,value);
      			} 
			else 
			{
			        System.out.println("  Inserted " + value + " to right of "+ node.value);
			        node.right = new Node(value);
      			}
    		}
  	}
	public static void search(Node node,int value)
	{
		if(value < node.value)
		{
			ptr=node;
			search(node.left,value);
		}
		else if(value > node.value)
		{
			ptr=node;
			search(node.right,value);
		}
		else
			nd=node;
	}
	public static void delete(Node node)
	{
		if(node.left==null && node.right==null)
		{
			if(ptr.left!=null)
				ptr.left=null;
			else
				ptr.right=null;
		}
		else if(node.left==null || node.right==null)
		{
			if(node.left!=null)
				node.value=node.left.value;
			else
				node.value=node.right.value;
			node.left=node.right=null;
		}
		else
		{
			ptr=node.right;
			if(ptr.left==null)
			{
				node.value=ptr.value;
				node.right=ptr.right;				
			}
			else
			{
				while(ptr.left!=null)
				{
					nd=ptr;
					ptr=ptr.left;
				}
				node.value=ptr.value;
				nd.left=null;
			}
		}
	}
	public static void inOrder(Node node) 
	{
    		if(node != null) 
		{
      			inOrder(node.left);
			System.out.print("  " + node.value);
			inOrder(node.right);
		}
  	}

  	public static void main(String[] args) 
	{
		run();
	}
}



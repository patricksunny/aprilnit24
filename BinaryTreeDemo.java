import java.util.*;
class Node
{ 
Object data;
Node left;
Node right;
Node( Object d )       // constructor
  { 
    data = d; 
  }
}

class BinaryTree
{
Object tree[];
int maxSize;

Stack<Node> stk=new Stack<Node>();

   BinaryTree( Object a[], int n )       // constructor
    { 
      maxSize = n;
      tree = new Object[maxSize];
      for( int i=0; i<maxSize; i++ )
           tree[i] = a[i];
    }

  public Node buildTree( int index )
   { 
     Node p = null;
     if( tree[index] != null )
     { 
       p = new Node(tree[index]);
       p.left = buildTree(2*index+1);
       p.right = buildTree(2*index+2);
     }
      return p;
   }

/* Recursive methods - Binary tree traversals */
   public void inorder(Node p)
    {
      if( p != null )
       {
 	inorder(p.left);
	System.out.print(p.data + " ");
	inorder(p.right);
       }
    }

  public void preorder(Node p)
   {
     if( p != null )
     {
	System.out.print(p.data + " ");
	preorder(p.left);
	preorder(p.right);
     }
   }

   public void postorder(Node p)
    {
      if( p != null )
       {
	 postorder(p.left);
	 postorder(p.right);
	 System.out.print(p.data + " ");
       }
     }

/* Non-recursive methods - Binary tree traversals */
   public void preorderIterative(Node p)
    {
     if(p == null )
      { 
       System.out.println("Tree is empty");
       return;
      }
     stk.push(p);
     while( !stk.isEmpty() )
     {
       p = stk.pop();
       if( p != null )
        {
          System.out.print(p.data + " ");
          stk.push(p.right);
          stk.push(p.left);
         }
       }
     }

   public void inorderIterative(Node p)
    {
      if(p == null )
       { 
         System.out.println("Tree is empty");
         return;
       }
      while( !stk.isEmpty() || p != null )
      {
        if( p != null )
         { 
           stk.push(p); // push left-most path onto stack
            p = p.left;
         }
        else
         {
           p = stk.pop(); 			// assign popped node to p
           System.out.print(p.data + " ");     // print node data
           p = p.right; // move p to right subtree
         }
        }
       }

   public void postorderIterative(Node p)
    {
      if(p == null )
       { 
         System.out.println("Tree is empty");
         return;
       }
       Node tmp = p;
       while( p != null )
        {
          while( p.left != null )
           { 
             stk.push(p);
             p = p.left;
           }
          while( p != null && (p.right == null || p.right == tmp ))
           { 
             System.out.print(p.data + " ");    // print node data
             tmp = p;
             if( stk.isEmpty() )
             return;
             p = stk.pop();
           }
  
           stk.push(p);
           p = p.right;
         }
      }
} // end of BinaryTree class

class B
{
   public static void main(String args[])
     {
       Object arr[] = {'E', 'C', 'G', 'A', 'D', 'F', 'H',null,'B', null, null, null, null,null, null, null, null, null, null};

       BinaryTree t = new BinaryTree( arr, arr.length );

       Node root = t.buildTree(0);              // buildTree() returns reference to root

       System.out.println("\nRecursive Binary Tree Traversals:\n");
       System.out.print("\n inorder: ");
       t.inorder(root);

       System.out.print("\n\n preorder: ");
       t.preorder(root);

       System.out.print("\n\npostorder: ");
       t.postorder(root);

       System.out.println("\n\nNon-recursive Binary Tree Traversals:");
       System.out.print("\n\n inorder: ");
       t.inorderIterative(root);

       System.out.print("\n\npreorder: ");
       t.preorderIterative(root);

       System.out.print("\n\n postorder: ");
       t.postorderIterative(root);
       System.out.println("\n"); 
     }
}
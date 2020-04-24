import java.util.*;


public class BFSearch
{
	static int visited[]=new int[20];
	static int graph[][]=new int[20][20];
	public static void bfSearch(int v,int n)
	{
		int i,j,u=v;
		visited[v]=1;
		LinkedList<Integer> q=new LinkedList<Integer>();
		while(true)
		{
			for(i=1;i<=n;i++)
				if(graph[u][i]!=0 && visited[i]==0)
				{
					q.add(i);
					visited[i]=1;
				}
			try
			{
				u=q.remove();
				System.out.print(" "+u);
			}
			catch(NoSuchElementException e)
			{
				return;
			}
		}
	}
	

public static void main(String args[])
	{
		int i,j,n,v;
		Scanner s=new Scanner(System.in);
		System.out.print("ENTER NO OF VERTICES:");
		n=s.nextInt();
		System.out.println("ENTER EDGE AS[1 2] FOR EDGE 1->2");
		System.out.println("DONT ENTER FOR 2->1 AGAIN, TO END ENTER [-1]");
		while(true)
		{
			i=s.nextInt();
			if(i==-1)
				break;
			j=s.nextInt();
			graph[i][j]=graph[j][i]=1;
		}	
		System.out.print("ENTER START VERTEX:");
		v=s.nextInt();
		System.out.println("BREADTH FIRST TRAVERSAL:");
		System.out.print(v);
		bfSearch(v,n);
	}
}

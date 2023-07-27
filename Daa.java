//Quick Sort
import java.util.*;

public class Quicksort
{   static int max = 50000;
    public static int partition(int a[],int low,int high)
   {    int i = low, j = high, pivot = a[low], temp;
       
		while(i<=j)
		{
			while(a[i] <= pivot) 
				i++;
			while(a[j] > pivot) 
				j--;
			if( i<j )
			{  temp=a[i]; 
			   a[i]=a[j]; 
			   a[j]=temp;
			}
        }
			    a[low]=a[j]; 
				a[j]=pivot; 
				return j;
	}

    public static void qs(int a[],int low,int high)
    {   int mid;
        if(low<high)
        {   mid = partition(a,low,high);
            qs(a,low,mid-1);
            qs(a,mid+1,high);
        }
    }

    public static void main(String[] args)
    {   int n,i;
        System.out.println("Enter the size:");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        int a[] = new int[max];

        Random rand = new Random();


        for(i=0;i<n;i++)
            a[i] = rand.nextInt(100);

        try
        {   System.out.println("The array elements are:");
            for(i=0;i<n;i++)
                System.out.println(a[i]);

            long start_time = System.nanoTime();
            qs(a,0,n-1);
            long end_time = System.nanoTime();

            System.out.println("The Sorted elements are:");
            for(i=0;i<n;i++)
                System.out.println(a[i]);

            System.out.println("Time taken: "+(end_time-start_time)+" nanoseconds");

         } catch (ArrayIndexOutOfBoundsException e)
           {
            System.out.println("Array size reached maximum");
           }
    }
}






package com.programs;
import java.util.*;

public class Prims 
{   public static void main(String[] args)
    {   int n,i,j,min=0,a=0,u=0,b=0,v=0,source;
        int ne = 1;
        int min_cost = 0;
        int cost[][] = new int[20][20];
        int visited[] = new int[20];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no. of nodes:");
        n = in.nextInt();
        System.out.println("Enter the cost matrix:");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                cost[i][j] = in.nextInt();
            
        for(i=1;i<=n;i++)
            visited[i] = 0;
        System.out.println("Enter the root node:");
        source = in.nextInt();
        visited[source] = 1;
        System.out.println("Minimum cost spanning tree is:");
        while(ne < n)
        {   min = 999;
            for(i=1;i<=n;i++)
		    {  for(j=1;j<=n;j++)
               {  if(cost[i][j] < min)
                        if(visited[i] == 0)
                            continue;
                        else 
						{   min = cost[i][j];
                            a=u=i;
                            b=v=j;
                        }
                }
            }

            if(visited[u]==0 || visited[v]==0) 
            {   ne++;
                System.out.println("Edge "+ne+"\t"+a+"-->"+b+"="+min);
                min_cost = min_cost+min;
                visited[b] = 1;
            }

            cost[a][b] = cost[b][a] = 999;
        }

        System.out.println("Minimum cost = "+min_cost);
    }
}

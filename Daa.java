import java.io.*;
import java.util.*;


public class SelSort {
    static int cmp = 0, swap = 0;

    public static int[] sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                cmp += 1;
                if (a[j] < min) {
                    flag = true;
                    min = j;
                }
            }
            if (flag) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
                swap += 1;
            }
        }
        return a;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] a;
        int n;


        System.out.println("Enter the number of array elements :(>5000): ");
        n = in.nextInt();
        a = new int[n];

        PrintWriter w = new PrintWriter("Sel-Avg.txt");
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt();
            w.print(a[i] + " ");
        }
        w.close();

        cmp = 0; swap = 0;
        long start_time = System.nanoTime();
        a = sort(a);
        long end_time = System.nanoTime();

        System.out.println("Comparisons: (Avg case): " + cmp);
        System.out.println("Time taken: "+(end_time-start_time)+" nanoseconds");

        PrintWriter o = new PrintWriter("Sel-Best.txt");
        for(int i: a)
            o.print(i + " ");
        o.close();
        cmp = 0; swap = 0;
        sort(a);
        System.out.println("Comparisons: (Best case): " + cmp);

        cmp = 0; swap = 0;
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            temp[n - i - 1] = a[i];
        }
        sort(temp);
        System.out.println("Comparisons: (Worst case): " + cmp);

    }
}



//merge
import java.util.Scanner;
import java.util.Random;
import java.io.*;

class MergeSort {
    int[] inputArr;
    int[] tempMergArr;
    int cnt;
    int size;

    void process() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to be sorted (>5000): ");
        size = scanner.nextInt();
        inputArr = new int[size];
        tempMergArr = new int[size];
        getRandomNumbers();
        cnt = 0;
        doMergeSort(0, inputArr.length - 1);

        PrintWriter outA = new PrintWriter(new File("mrg_asort.txt"));
        for (int i : inputArr)
            outA.print(i + " ");
        outA.close();

        System.out.println("Time complexity is: " + cnt);
        scanner.close();
    }

    void getRandomNumbers() throws IOException {
        Random rand = new Random();
        int count = 0;
        PrintWriter out = new PrintWriter(new File("Mrandom.txt"));
        while (count < size) {
            int number = rand.nextInt(size) + 1;
            inputArr[count] = number;
            out.print(number + " ");
            count++;
        }
        out.close();
        System.out.println("The total numbers generated: " + count);
    }

    void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);

            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++)
            tempMergArr[i] = inputArr[i];
        int i = lowerIndex, j = middle + 1, k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                inputArr[k] = tempMergArr[i];
                i++;
                cnt++;
            } else {
                inputArr[k] = tempMergArr[j];
                j++;
                cnt++;
            }
            k++;
        }

        while (i <= middle) {
            inputArr[k] = tempMergArr[i];
            k++;
            i++;
        }

        while (j <= higherIndex) {
            inputArr[k] = tempMergArr[j];
            k++;
            j++;
        }
    }
}

public class mergeS {
    public static void main(String args[]) throws IOException {
        MergeSort msort = new MergeSort();
        msort.process();
    }
}




import java.util.*;
public class Mergesort {
static int max = 50000;
public static void mergeSort(int a[], int low, int high) {
int mid;
if (low < high) {
mid = (low + high) / 2;
mergeSort(a, low, mid);
mergeSort(a, mid + 1, high);
merge(a, low, mid, high);
}
}
public static void merge(int a[], int low, int mid, int high) {
int k = low, j = mid + 1, i = low;
int c[] = new int[1000];
while ((i <= mid) && (j <= high)) {
if (a[i] <= a[j])
c[k++] = a[i++];
else
c[k++] = a[j++];
}
while (i <= mid)
c[k++] = a[i++];
while (j <= high)
c[k++] = a[j++];
for (i = low; i <= high; i++)
a[i] = c[i];
}
public static void main(String args[]) {
int n, i;
System.out.println("Enter the size:");
Scanner in = new Scanner(System.in);
n = in.nextInt();
in.close();
Random rand = new Random();
int a[] = new int[max];
for (i = 0; i < n; i++)
a[i] = rand.nextInt(100);
System.out.println("The random elements are:");
for (i = 0; i < n; i++)
System.out.print(a[i]+" ");
try {
long start_time = System.nanoTime();
mergeSort(a, 0, n - 1);
long end_time = System.nanoTime();
System.out.println();
System.out.println("The sorted array:");
for (i = 0; i < n; i++)
System.out.print(a[i]+" ");
System.out.println();
System.out.println("Time taken: " + (end_time - start_time) + " nanoseconds");
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Array index max reached");
}
}
}



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



//krushkal

import java.util.Scanner;

public class Kruskal
{   public static int find(int v,int s[])    
    {    while(s[v]!=v)
            v =s[v];
        return v;
    }

    public static void union1(int i,int j,int s[])
    {
        s[i] = j;
    }

    public static void kruskal(int n,int c[][])
    {   int count,i,min=0,j,u=0,v=0,k,sum;
        int s[] = new int[10];
        int t[][] = new int[10][2];
        for(i=0;i<n;i++)
            s[i] = i;
        count = 0;
        sum = 0;
        k = 0;
        while(count<n-1)
		{   min = 999;
            for(i=0;i<n;i++)
			{ for(j=0;j<n;j++)
			  {  if(c[i][j] != 0 && c[i][j]<min)
                   {
                     min = c[i][j];
                     u  = i;
                     v = j;
                   }
              }
            }

            if(min==999) break;
            i = find(u,s);
            j = find(v,s);

            if(i!=j) 
			{   t[k][0] = u;
                t[k][1] = v;
                k++;
                count++;
                sum+=min;
                union1(i,j,s);
            }

            c[u][v] = c[v][u] = 999;
        }

        if(count==n-1) 
		{   System.out.println("Cost of Spanning tree: "+sum);
            System.out.println("Spanning tree is:");
            for(k=0;k<n-1;k++)
                System.out.println(t[k][0]+","+t[k][1]);
        }
        else
            System.out.println("Spanning tree dosent exist");
    }

    public static void main(String[] args)
	{   int n,i,j;
        int c[][] = new int[10][10];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no. of nodes:");
        n = in.nextInt();
        System.out.println("Enter the cost Adjacency matrix:");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                c[i][j] = in.nextInt();
        kruskal(n,c);
    }
}

//sssp



// Dijksthra Algorithm -- SSSP Problem 

import java.util.Scanner;

public class Sssp 
{
    static int[][] cost;
    static int dist[],n;
    
    static int min(int m, int n)
    {    
        return(( m < n) ? m: n);
    }

    static void Dijkstra(int source)
    { 
        int[] s=new int[n];
        int min, w=0;
        System.arraycopy(cost[source], 0, dist, 0, n);
        //Initialize dist from source to source as 0 
        //mark source vertex - estimated for its shortest path
        s[source] = 1;  dist[source] = 0;
        for(int i=0; i < n-1; i++)
        {     
            //Find the nearest neighbour vertex
            min = 999;
            for(int j = 0; j < n; j++)
                if ((s[j] == 0 ) && (min > dist[j]))
                { 
                    min = dist[j];
                    w = j;
                }
            s[w]=1;
            //Update the shortest path of neighbour of w
            for(int v=0;v<n;v++)
                if(s[v]==0 && cost[w][v]!=999)
                {
                    dist[v]= min(dist[v],dist[w]+cost[w][v]);
                }
        }
    }
    
    public static void main(String[] args) 
    {
        int source;
        Scanner s=new Scanner(System.in);
        
        System.out.println("Enter the no.of vertices");
        n = s.nextInt();
        cost = new int[n][n];
        dist = new int[n];
        
        //Enter the cost matrix, 999 for no direct edge from i to j
        System.out.println("Enter the cost matrix");
        for(int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                cost[i][j] = s.nextInt();
        
        System.out.println("Enter the source vertex");
        source = s.nextInt();
        Dijkstra(source);
        
        System.out.println(" the shortest distance is...");
        for(int i=0; i<n; i++)
            System.out.println("Cost from "+source+" to "+i+" is " + dist[i]);
    }
}


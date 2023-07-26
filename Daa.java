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


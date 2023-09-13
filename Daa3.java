
import java.util.Scanner;
public class sos {

	    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of objects: ");
        	int n = scanner.nextInt();
	        int[] set = new int[n];
            System.out.print("Enter the elements: ");
        	
            for(int i = 0; i < n; i++) {
                set[i]=scanner.nextInt();
            }
            System.out.print("enter target sum: ");
	        int targetSum = scanner.nextInt();

	        System.out.println("Subsets with the target sum:");
	        findSubsetsWithSum(set, targetSum, new int[set.length], 0, 0);
	    }

	    // Recursive function to find and print subsets with the target sum
	    static void findSubsetsWithSum(int[] set, int targetSum, int[] currentSubset, int currentIndex, int currentSum) {
	        if (currentSum == targetSum) {
	            // Print the current subset
	            for (int i = 0; i < currentIndex; i++) {
	            	if(currentSubset[i]==0) {
	            		continue;
	            	}
	                System.out.print(currentSubset[i] + " ");
	            }
	            System.out.println();
	        }

	        if (currentIndex == set.length || currentSum >= targetSum) {
	            return;
	        }

	        // Include the current element in the subset
	        currentSubset[currentIndex] = set[currentIndex];
	        findSubsetsWithSum(set, targetSum, currentSubset, currentIndex + 1, currentSum + set[currentIndex]);

	        // Exclude the current element from the subset
	        currentSubset[currentIndex] = 0; // Reset the element
	        findSubsetsWithSum(set, targetSum, currentSubset, currentIndex + 1, currentSum);
	    }
	}

import java.util.Scanner;

public class knap {
	    static void max(float x[], float knapsackweight, float weight[], int n) {
	        float maxx = 0;
	        float profit = 0;
	        int k = 0;
			System.out.print("Selected elements are: ");
	        for (int j = 0; j < n; j++)
	           {
	        	maxx = 0;
	            for (int i = 0; i < n - j; i++) 
	            {
	                if (x[i] > maxx)
	                    maxx = x[i];
	                k = i;
	            }
				
	            if (weight[k] < knapsackweight) 
	            {   System.out.print((k+1)+" ");
	                profit = profit + weight[k] * maxx;
	                knapsackweight = knapsackweight - weight[k];
	                
	    	    }
	            else if((knapsackweight!=0)&&(weight[k] > knapsackweight))
        		{       System.out.println( (k+1)+" ");
        	            
        	            profit=profit+ knapsackweight * maxx;
        	           
        		knapsackweight=0;
        		}
	        }
	      System.out.println("Profit: " + profit);
	        
	    }

	    public static void main(String[] args) 
	        {
			Scanner scanner = new Scanner(System.in);

        	System.out.print("Enter the number of objects: ");
        	int n = scanner.nextInt();
        	
	        float[] profit = new float[n];
	        float[] weight = new float[n];
	        float[] x = new float[profit.length];
			System.out.print("Enter the profits as space-separated values: ");
        	for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextFloat();
        	}
			System.out.print("Enter the weight as space-separated values: ");
        	for (int i = 0; i < n; i++) {
            	weight[i] = scanner.nextFloat();
        	}
			System.out.println("enter capacity of knapsack");
			float knapsackweight = scanner.nextFloat();
	        for (int i = 0; i < profit.length; i++) 
	        {
	            x[i] = (float) profit[i] / weight[i];
	            
	        }

	        max(x, knapsackweight, weight, n);
	        }
	}

//001

import java.util.Scanner;

public class Knapsack {
    double weight[];
    double benefit[];
    double ratio[];
    double W;

    Knapsack() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of objects: ");
        int nItems = scan.nextInt();
        weight = new double[nItems];
        ratio = new double[nItems];
        benefit = new double[nItems];
        System.out.println("Enter the object's weights");
        for (int i = 0; i < nItems; ++i)
            weight[i] = scan.nextDouble();
        System.out.println("Enter the object's profits");
        for (int i = 0; i < nItems; ++i)
            benefit[i] = scan.nextDouble();
        for (int i = 0; i < nItems; ++i)
            ratio[i] = benefit[i] / weight[i];
        System.out.println("Enter the Capacity of the knapsack: ");
        W = scan.nextDouble();
    }

    int getNext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < benefit.length; ++i) {
            if (ratio[i] > highest && weight[i] > 0) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        double cW = 0; // current weight
        double cB = 0; // current benefit
        System.out.print("\n Objects considered: ");
        while (cW < W) {
            int item = getNext(); // next highest ratio
            if (item == -1) { // No items left
                break;
            }
            System.out.print((item + 1) + " ");
            if (cW + weight[item] <= W) {
                cW += weight[item];
                cB += benefit[item];
                weight[item] = 0; // mark as used
            } else {
                cB += (ratio[item] * (W - cW));
                cW += (W - cW);
                break; // the knapsack is full
            }
        }
        System.out.println("\nThe Optimal Solution i.e. Max Benefit = " + cB);
    }

    public static void main(String[] args) {
        Knapsack fk = new Knapsack();
        fk.fill();
    }
}


//002


import java.util.Scanner;

public class Floyd {
	private int dmat[][];
	private int n;
	public static final int INFINITY = 999;

	public Floyd(int n) {
		dmat = new int[n + 1][n + 1];
		this.n = n;
	}

	public void floyd_compute(int adjmat[][]) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dmat[i][j] = adjmat[i][j];
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dmat[i][k] + dmat[k][j] < dmat[i][j])
						dmat[i][j] = dmat[i][k] + dmat[k][j];
				}
			}
		}
		for (int i = 1; i <= n; i++)
			System.out.print("\t" + i);
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.print(i + "\t");
			for (int j = 1; j <= n; j++) {
				System.out.print(dmat[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] arg) {
		int adjmat[][];
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = scan.nextInt();
		adjmat = new int[n + 1][n + 1];
		System.out.println("Enter the Weighted Matrix for the graph");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				adjmat[i][j] = scan.nextInt();
				if (i == j) {
					adjmat[i][j] = 0;
					continue;
				}
				if (adjmat[i][j] == 0) {
					adjmat[i][j] = INFINITY;
				}
			}
		}
		System.out.println("The All Pairs Shortest Distance of the Graph is: ");
		Floyd floydobj = new Floyd(n);
		floydobj.floyd_compute(adjmat);
		scan.close();
	}
}


//003

import java.util.Scanner;

class TSP {
    static int cost = 0;

    public static void main(String[] args) {
        int a[][] = new int[10][10];
        int visited[] = new int[10];
        int n;
        System.out.println("Enter number of cities: ");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        create(a, visited, n);
        System.out.println("\n\npath is");
        mincost(a, n, 0, visited);
        display();
    }

    public static void display() {
        // TODO Auto-generated method stub
        System.out.println("\n total cost of tour=" + cost);
    }

    public static void mincost(int[][] a, int n, int city, int[] visited) {
        int i, city_no;
        visited[city] = 1;
        System.out.print((city + 1) + "--> ");
        city_no = least(a, visited, n, city);
        if (city_no == 999) {
            city_no = 0;
            System.out.print(" " + (city_no + 1));
            cost += a[city][city_no];
            return;
        }
        mincost(a, n, city_no, visited);
    }

    public static int least(int[][] a, int[] visited, int n, int c)
    // returns the city which is reachable from source in minimum cost
    {
        int i, min_node = 999;
        int min = 999;
        int new_min = 0;
        for (i = 0; i < n; i++) {
            if ((a[c][i] != 0) && visited[i] == 0)// if path exist and next city to reach is not yet visited (minimum
                                                  // distance
                                                  // city nerer to source i.e 0)
                if (a[c][i] < min) {
                    min = a[i][0] + a[c][i];
                    new_min = a[c][i];
                    min_node = i;
                }
        }
        if (min != 999)
            cost += new_min;
        return min_node;
    }

    public static void create(int[][] a, int[] visited, int n) {
        System.out.println("\n enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println("row:" + (i + 1));
            for (int j = 0; j < n; j++) {
                Scanner scan = new Scanner(System.in);
                a[i][j] = scan.nextInt();
            }
            visited[i] = 0;
        }
        System.out.println("\n\nThe cost matrix");
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + a[i][j]);
            }
        }
    }
}

//004

import java.util.Scanner;

class Knapsack_DP {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int C, int wt[], int val[], int n) {
        int i, j;
        int[][] K = new int[n + 1][C + 1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= C; j++) {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (wt[i - 1] <= j)
                    K[i][j] = max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);
                else
                    K[i][j] = K[i - 1][j];
            }
        }
        System.out.println("Knapsack table");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= C; j++) {
                System.out.print(K[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Items Considered: ");
        i = n;
        j = C;
        while (i > 0 && j > 0) {
            if (K[i][j] != K[i - 1][j]) {
                System.out.print(i + " ");
                j -= wt[i - 1];
            }
            i -= 1;
        }
        return K[n][C];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Objects: ");
        int n = sc.nextInt();
        System.out.println("Enter the object's weights: ");
        int[] wt = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        System.out.println("Enter the object's profits: ");
        int[] val = new int[n];
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        System.out.println("Enter the maximum capacity: ");
        int C = sc.nextInt();
        System.out.println(
                "\nThe Maximum value that can be put in a knapsack of capacity W is: " + knapSack(C, wt, val, n));
        sc.close();
    }
}


//005

import java.util.Scanner;

public class SumOfSubsets {
    int[] w;
    int[] x;
    int sum;
    int total=0;

    int n;

    public void process() {
        getData();
        System.out.println("The subsets are:");
        subset(0, 1, total);
    }

    private void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        n = sc.nextInt();
        w = new int[n + 1];
        x = new int[n + 1];
        System.out.println("Enter " + n + " Elements :");
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            total+=w[i];
        }
        System.out.println("Enter the sum to be obtained: ");
        sum = sc.nextInt();
        if (total < sum){
            System.out.println("No possible subsets!!!");
            System.exit(1);
        }

        sc.close();
    }

    private void subset(int s, int k, int r) {
        x[k] = 1;
        int i=0;
        if (s + w[k] == sum) {
            System.out.print("(");
            for (i = 1; i <= k; i++) {
                if (x[i] == 1) {
                    System.out.print(" " + w[i]);
                }
            }
            System.out.println(" )");
        } else if (s + w[k] + w[k + 1] <= sum) {
            subset(s + w[k], k + 1, r - w[k]);
        }
        if ((s + r - w[k] >= sum) && (s + w[k + 1] <= sum)) {
            x[k] = 0;
            subset(s, k + 1, r - w[k]);
        }
    }

    public static void main(String[] args) {
        new SumOfSubsets().process();
    }
}


//006

import java.util.*;

public class Hamiltonian {
    static int MAX = 25;
    static int vertex[] = new int[MAX];

    public static void main(String[] args) {
        int i, j, v1, v2, edges, n;
        int G[][] = new int[MAX][MAX];
        System.out.println("\n\t program for Hamiltonian cycle");
        System.out.println("enter the number of vertices of graph");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                G[i][j] = 0;
                vertex[i] = 0;
            }
        }
        System.out.println("\n enter the total number of edges:");
        edges = in.nextInt();
        for (i = 1; i <= edges; i++) {
            System.out.println("enter the edge:");
            v1 = in.nextInt();
            v2 = in.nextInt();
            G[v1][v2] = 1;
            G[v2][v1] = 1;
        }
        vertex[1] = 1;
        System.out.println("Hamiltonian cycle");
        H_cycle(G, n, 2);
    }

    public static void next_vertex(int G[][], int n, int k) {
        int j;
        while (true) {
            vertex[k] = (vertex[k] + 1) % (n + 1);
            if (vertex[k] == 0)
                return;
            if (G[vertex[k - 1]][vertex[k]] != 0) {
                for (j = 1; j <= k - 1; j++) {
                    if (vertex[j] == vertex[k])
                        break;
                }
                if (j == k) {
                    if ((k < n) || ((k == n) && (G[vertex[n]][vertex[1]] != 0)))
                        return;
                }
            }
        }
    }

    public static void H_cycle(int G[][], int n, int k) {
        int i;
        while (true) {
            next_vertex(G, n, k);
            if (vertex[k] == 0)
                return;
            if (k == n) {
                System.out.println("\n");
                for (i = 1; i <= n; i++)
                    System.out.print(vertex[i] + "-->");
                System.out.println(" " + vertex[1]);
            } else
                H_cycle(G, n, k + 1);
        }
    }
}


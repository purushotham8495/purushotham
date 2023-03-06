#include <stdio.h>
#include <stdlib.h>
int n, a[10][10], i, j, source, s[10], reach[10], choice, count = 0;
void bfs(int n, int a[10][10], int source, int s[])
{
    int q[10], u;
    int front = 1, rear = 1;
    s[source] = 1;
    q[rear] = source;
    while (front <= rear)
    {
        u = q[front];
        front = front + 1;
        for (i = 1; i <= n; i++)
            if (a[u][i] == 1 && s[i] == 0)
            {
                rear = rear + 1;
                q[rear] = i;
                s[i] = 1;
            }
    }
}
void dfs(int v)
{
    int i;
    reach[v] = 1;
    for (i = 1; i <= n; i++)
    {
        if (a[v][i] && !reach[i])
        {
            printf("\n%d->%d", v, i);
            count++;
            dfs(i);
        }
    }
}
int main()
{
    printf("enter the number of nodes:");
    scanf("%d", &n);
    printf("\nenter the adjacency matrix\n");
    for (i = 1; i <= n; i++)
        for (j = 1; j <= n; j++)
            scanf("%d", &a[i][j]);
    while (1)
    {
        printf("\nenter your choice\n");
        printf("1.BFS\n2.DFS\n3.exit\n");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            printf("\n enter the source:");
            scanf("%d", &source);
            for (i = 1; i <= n; i++)
                s[i] = 0;
            bfs(n, a, source, s);
            for (i = 1; i <= n; i++)
            {
                if (s[i] == 0)
                    printf("\nthe node %d is not reachable", i);
                else
                    printf("\nthe node %d is reachable", i);
            }
            break;
        case 2:
            dfs(1);
            if (count == n - 1)
                printf("\nthe graph is connected");
            else
                printf("\nthe graph is not connected");
            break;
        case 3:
            exit(0);
        }
    }
}
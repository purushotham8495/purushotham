#include <stdio.h>
#include <stdlib.h>
struct sll
{
    int data;
    struct sll *next;
};
typedef struct sll node;
node *start = NULL;
node *create()
{
    node *new1;
    new1 = (node *)malloc(sizeof(node));
    printf("Enter the data");
    scanf("%d", &new1->data);
    new1->next = NULL;
    return new1;
}
void insert_begin()
{
    node *new1;
    new1 = create();
    if (new1 == NULL)
    {
        printf("\nOverflow");
    }
    else
    {
        new1->next = start;
        start = new1;
    }
}
void delete_begin()
{
    node *temp;
    if (start == NULL)
    {
        printf("\nList is empty\n");
    }
    else
    {
        temp = start;
        printf("Deleted node data is %d", temp->data);
        start = start->next;
        free(temp);
    }
}
void print()
{
    node *temp;
    temp = start;
    if (temp == NULL)
    {
        printf("Stack empty");
    }
    else
    {
        printf("\nContents of the stack are:\n");
        while (temp != NULL)
        {
            printf("\n%d", temp->data);
            temp = temp->next;
        }
    }
}
void search()
{
    int key, i = 0, flag = 0;
    node *temp = start;
    if (start == NULL)
    {
        printf("Stack empty\n");
    }
    else
    {
        printf("enter the search element\n");
        scanf("%d", &key);
        while (temp != NULL)
        {
            i++;
            if (key == temp->data)
            {
                flag = 1;
                break;
            }
            temp = temp->next;
        }
        if (flag == 0)
            printf("Search element not found in the list\n");
        else
            printf("Search element found at position %d\n", i);
    }
}
void main()
{
    int ch = 0;
    while (1)
    {
        printf("\nEnter the operation to be performed\n");
        printf("\n1.Insert \n2.Delete \n3.Display \n4.Seach \n5.Exit\n");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            insert_begin();
            break;
        case 2:
            delete_begin();
            break;
        case 3:
            print();
            break;
        case 4:
            search();
            break;
        case 5:
            exit(0);
        default:
            printf("Enter valid option\n");
        }
    }
}
/*Output:
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
1
Enter the data50
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
1
Enter the data256
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search5.Exit
1
Enter the data27
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
3
Contents of the stack are:
27
256
50
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
4
enter the search element
50
Search element found at position 3
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
2
Deleted node data is 27
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
2
Deleted node data is 256
Enter the operation to be performed1.Insert
2.Delete
3.Display
4.Search
5.Exit
2
Deleted node data is 50
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
2
List is empty
Enter the operation to be performed
1.Insert
2.Delete
3.Display
4.Search
5.Exit
5
*/
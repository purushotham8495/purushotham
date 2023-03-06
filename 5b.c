// Create a SLL queue of N students data concatenation of two SLL of integers.
#include <stdio.h>
#include <stdlib.h>
struct student
{
    char name[20];
    int usn;
    struct student *next;
};
typedef struct student node;
node *start = NULL, *start2 = NULL;
node *create()
{
    node *new1;
    new1 = (node *)malloc(sizeof(node));
    printf("Enter name and usn:\n");
    scanf("%s %d", new1->name, &new1->usn);
    new1->next = NULL;
    return new1;
}
void insertend()
{
    node *new1, *temp = start;
    new1 = create();
    if (start == NULL)
    {
        start = new1;
        return;
    }
    while (temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = new1;
}
void deletebegin()
{
    if (start == NULL)
    {
        printf("List empty\n");
        return;
    }
    node *temp = start;
    start = start->next;
    printf("Deleted node data:%s\t %d\n", temp->name, temp->usn);
    free(temp);
}
void concat()
{
    node *newnode;
    int count, i;
    printf("Enter the number of nodes in second list");
    scanf("%d", &count);
    for (i = 1; i <= count; i++)
    {
        newnode = create();
        if (start2 == NULL)
        {
            start2 = newnode;
        }
        else
        {
            newnode->next = start2;
            start2 = newnode;
        }
    }
    if (start == NULL)
    {
        start = start2;
    }
    else
    {
        node *temp = start;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = start2;
    }
}
void display()
{
    node *temp;
    temp = start;
    if (temp == NULL)
    {
        printf("\nQueue empty");
    }
    else
    {
        printf("\nContents of the stack are:\n");
        while (temp != NULL)
        {
            printf("\n%d", temp->usn);
            temp = temp->next;
        }
    }
}
void main()
{
    int ch = 0;
    while (1)
    {
        printf("\n1.Insert \n2.Delete \n3.Concatenate \n4.Display \n5.Exit\n");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            insertend();
            break;
        case 2:
            deletebegin();
            break;
        case 3:
            concat();
            break;
        case 4:
            display();
            break;
        case 5:
            exit(0);
        }
    }
}
/*
Output:
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
1
Enter name and usn:
rakshitha
35
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
1
Enter name and usn:
hemanth
12
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
1
Enter name and usn:
sabitha46
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
4
Contents of the stack are:
35
12
46
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
Deleted node data:rakshitha35
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
Deleted node data:hemanth12
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
3
Enter the number of nodes in second list2
Enter name and usn:
vignesh
58
Enter name and usn:
nidhi
37
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
4Contents of the stack are:
46
37
58
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
Deleted node data:sabitha
46
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
Deleted node data:nidhi 37
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
Deleted node data:vignesh
1.Insert
2.Delete
3.Concatenate
4.Display
5.Exit
2
List empty
1.Insert
2.Delete
3.Concatenate
4.Display
*/
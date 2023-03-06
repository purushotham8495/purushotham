// 8.Design,Develop and implement a menu driven program in c for the following
// operations on
// binary search tree of integers
// a.Create a bst of n integers
// b.Traverse the bst in inorder,preorder and postorder.
#include <stdio.h>
#include <stdlib.h>
struct bst
{
    int info;
    struct bst *lptr, *rptr;
};
typedef struct bst node;
node *generate_tree(node *root, int data)
{
    node *new1 = malloc(sizeof(node));
    new1->lptr = new1->rptr = NULL;
    new1->info = data;
    if (!root)
    {
        root = new1;
        return root;
    }
    node *pathfinder = root, *temp;
    while (pathfinder)
    {
        temp = pathfinder;
        if (data >= pathfinder->info)
            pathfinder = pathfinder->rptr;
        else
            pathfinder = pathfinder->lptr;
    }
    if (data >= temp->info)
        temp->rptr = new1;
    if (data < temp->info)
        temp->lptr = new1;
    return root;
}
void inorderdisplay(node *root)
{
    if (root != NULL)
    {
        inorderdisplay(root->lptr);
        printf("%d\t", root->info);
        inorderdisplay(root->rptr);
    }
}
void preorderdisplay(node *root)
{
    if (root != NULL)
    {
        printf("%d\t", root->info);
        preorderdisplay(root->lptr);
        preorderdisplay(root->rptr);
    }
}
void postorderdisplay(node *root)
{
    if (root != NULL)
    {
        postorderdisplay(root->lptr);
        postorderdisplay(root->rptr);
        printf("%d\t", root->info);
    }
}
node *iosfunction(node *root)
{
    root = root->rptr;
    while (root->lptr)
        root = root->lptr;
    return root;
}
node *delete (node *root, int key)
{
    if (!root)
    {
        printf("element not found\n");
        return NULL;
    }
    if (key > root->info)
        root->rptr = delete (root->rptr, key);
    else if (key < root->info)
        root->lptr = delete (root->lptr, key);
    else
    {
        if (!root->lptr)
        {
            node *temp = root->rptr;
            free(root);
            return temp;
        }
        if (!root->rptr)
        {
            node *temp = root->lptr;
            free(root);
            return temp;
        }
        node *ios = iosfunction(root);
        root->info = ios->info;
        root->rptr = delete (root->rptr, ios->info);
    }
    return root;
}
void main()
{
    node *root = NULL;
    int i, data[] = {40, 20, 50, 10, 30, 45, 65};
    for (i = 0; i < 7; i++)
        root = generate_tree(root, data[i]);
    inorderdisplay(root);
    printf("\t-inorder\n");
    preorderdisplay(root);
    printf("\t-preorder\n");
    postorderdisplay(root);
    printf("\t-postorder\n");
    printf("enter element to be deleted\n");
    int key;
    scanf("%d", &key);
    root = delete (root, key);
    inorderdisplay(root);
    printf("\t-inorder\n");
    preorderdisplay(root);
    printf("\t-preorder\n");
    postorderdisplay(root);
    printf("\t-postorder\n");
}
/*
Output:
10
20
30
40
45
40
20
10
30
50
10
30
20
45
65
enter element to be deleted
45
10
20
30
40
50
40 20 10
30
50
10
30
20
65
50
50
45
50
65
65
40
65
65
40
-inorder
-preorder
-postorder
-inorder
-preorder
-postorder
*/
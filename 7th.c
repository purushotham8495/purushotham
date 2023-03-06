// 7.Given an array of elements, construct a complete binary tree from this array in level
// order fashion.That is ,elements from left in the array will be filled in the tree level wise
// starting from level 0.
#include <stdio.h>
#include <stdlib.h>
struct tree
{
    int data;
    struct tree *left, *right;
};
typedef struct tree node;
int tree_height(node *root)
{
    if (!root)
        return 0;
    else
    {
        int left_height = tree_height(root->left);
        int right_height = tree_height(root->right);
        if (left_height >= right_height)
            return left_height + 1;
        else
            return right_height + 1;
    }
}
void print_level(node *root, int level_no)
{
    if (!root)
        return;
    if (level_no == 0)
        printf("%d->", root->data);
    else
    {
        print_level(root->left, level_no - 1);
        print_level(root->right, level_no - 1);
    }
}
void print_tree_level_order(node *root)
{
    int i;
    if (!root)
        return;
    int height = tree_height(root);
    for (i = 0; i < height; i++)
    {
        printf("level %d\t", i);
        print_level(root, i);
        printf("\n");
    }
    printf("\n\n---Complete level order traversal---\n");
    for (i = 0; i < height; i++)
        print_level(root, i);
    printf("\n");
}
node *newnode(int data)
{
    node *node1 = (node *)malloc(sizeof(node));
    node1->data = data;
    node1->left = node1->right = NULL;
    return node1;
}
node *insertlevelorder(int arr[], int i, int n)
{
    node *root = NULL;
    if (i < n)
    {
        root = newnode(arr[i]);
        root->left = insertlevelorder(arr, 2 * i + 1, n);
        root->right = insertlevelorder(arr, 2 * i + 2, n);
    }
    return root;
}
int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    node *root = insertlevelorder(arr, 0, n);
    print_tree_level_order(root);
}
/*
Output:
level 0 1->
level 1 2->3->
level 2 4->5->6->
---Complete level order traversal-
*/
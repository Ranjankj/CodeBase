// Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

class Solution
{
public:
    // Function to convert binary tree to doubly linked list and return it.
    Node *prev = NULL;

    Node *bToDLL(Node *root)
    {
        // your code here
        if (root == NULL)
            return NULL;

        Node *head = bToDLL(root->left);

        if (prev == NULL)
            head = root;
        else
        {
            root->left = prev;
            prev->right = root;
        }
        prev = root;

        bToDLL(root->right);
        return head;
    }
};
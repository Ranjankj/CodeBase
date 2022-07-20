// Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    int ans = 0, count = 0;
    void helper(TreeNode *root, int k)
    {
        if (root != NULL)
        {
            helper(root->left, k);
            count++;
            if (count == k)
            {
                ans = root->val;
                return;
            }
            helper(root->right, k);
        }
    }

    int kthSmallest(TreeNode *root, int k)
    {
        helper(root, k);
        return ans;
    }
};
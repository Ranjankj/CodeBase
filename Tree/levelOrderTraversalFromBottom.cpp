// Link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/

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
    int height(TreeNode *root)
    {
        if (root == NULL)
            return 0;
        else
            return 1 + max(height(root->left), height(root->right));
    }

    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        int h = height(root);
        vector<vector<int>> result(h);

        if (root == NULL)
            return result;

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int n = q.size();
            vector<int> level;

            for (int i = 0; i < n; i++)
            {
                TreeNode *curr = q.front();
                q.pop();

                level.push_back(curr->val);

                if (curr->left)
                    q.push(curr->left);
                if (curr->right)
                    q.push(curr->right);
            }

            result[h - 1] = level;
            h--;
        }

        return result;
    }
};
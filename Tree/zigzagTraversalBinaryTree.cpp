// Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        vector<vector<int>> result;
        if (root == NULL)
            return result;

        stack<TreeNode *> s1;
        stack<TreeNode *> s2;

        s1.push(root);

        while (!s1.empty() || !s2.empty())
        {
            vector<int> tmp;
            while (!s1.empty())
            {
                TreeNode *curr = s1.top();
                s1.pop();
                tmp.push_back(curr->val);

                if (curr->left)
                    s2.push(curr->left);
                if (curr->right)
                    s2.push(curr->right);
            }

            if (tmp.size() != 0)
                result.push_back(tmp);
            tmp.clear();

            while (!s2.empty())
            {
                TreeNode *curr = s2.top();
                s2.pop();
                tmp.push_back(curr->val);

                if (curr->right)
                    s1.push(curr->right);
                if (curr->left)
                    s1.push(curr->left);
            }

            if (tmp.size() != 0)
                result.push_back(tmp);
            tmp.clear();
        }

        return result;
    }
};
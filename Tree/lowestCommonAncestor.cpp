// Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    bool getPath(TreeNode *root, TreeNode *target, vector<TreeNode *> &path)
    {
        if (root == NULL)
            return false;
        ;

        path.push_back(root);

        if (root == target)
            return true;

        bool l = getPath(root->left, target, path);
        bool r = getPath(root->right, target, path);

        if (l || r)
            return true;

        path.pop_back();

        return false;
    }

    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == NULL)
            return NULL;

        vector<TreeNode *> path1, path2;

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i = 0;
        for (i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++)
        {
            if (path1[i + 1] != path2[i + 1])
                return path1[i];
        }

        if (path1[i] == path2[i])
            return path1[i];

        return root;
    }
};
// problem limk : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// solution: 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder,0,preorder.length-1, inorder,0,inorder.length-1,map);
    }
    
    public TreeNode helper(int pre[], int preStart, int preEnd, 
                           int[] in, int inStart,int inEnd, 
                           HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        
        TreeNode root= new TreeNode(pre[preStart]);
        int rootIndex = map.get(root.val);
        int nol = rootIndex-inStart; // number of element on the left side of the root in inorder
        
        root.left = helper(pre,preStart+1,preStart+nol,in,inStart,rootIndex-1,map);
        root.right = helper(pre,preStart+nol+1,preEnd,in,rootIndex+1,inEnd,map);
        return root;
    }
}









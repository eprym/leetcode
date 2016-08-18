/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode newRoot = root;
        if(newRoot == null) return null;
        while(newRoot.left != null) {
            newRoot = newRoot.left;
        }
        helper(root);
        return newRoot;
    }
    
    private TreeNode helper(TreeNode root) {
        if(root == null)    return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left == null)    return root;
        else {
            left.left = root.right;
            left.right = root;
            root.left = root.right = null;
            return left.right;
        }
    }
}

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
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null) return true;
        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }

    private int heightHelper(TreeNode root) {
        // base case
        if(root == null) return 0;
        int left = heightHelper(root.left);
        int right = heightHelper(root.right);
        return 1 + Math.max(left, right);
    }
}

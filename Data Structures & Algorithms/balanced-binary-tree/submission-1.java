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
        if(root == null) {
            return true;
        }
        int leftMax = maxHeight(root.left);
        int rightMax = maxHeight(root.right);
        if(Math.abs(leftMax - rightMax) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHeight(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }
        // left
        int left = 1 + maxHeight(root.left);
        int right = 1 + maxHeight(root.right);
        return Math.max(left, right);
    }
}

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
    public int diameterOfBinaryTree(TreeNode root) {
        // base case
        if(root == null) return 0;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        int includingRoot = leftHeight + rightHeight;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(includingRoot, leftDiameter + rightDiameter);
    }

    private int helper(TreeNode root) {
        // base case
        if(root == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}

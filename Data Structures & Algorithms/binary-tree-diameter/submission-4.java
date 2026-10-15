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
        int left = helperMaxHeight(root.left);
        int right = helperMaxHeight(root.right);
        int throughRoot = left + right;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(throughRoot, leftDiameter + rightDiameter);
    }

    private int helperMaxHeight(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }
        int left = helperMaxHeight(root.left);
        int right = helperMaxHeight(root.right);
        return 1 + Math.max(left, right);
    }
}

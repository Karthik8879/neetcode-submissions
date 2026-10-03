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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxHelper(root);
        return maxi;
    }

    private int maxHelper(TreeNode root) {
        // base case
        if(root == null) return 0;
        int leftSum = Math.max(0, maxHelper(root.left)); // we want to consider only >= 0
        int rightSum = Math.max(0, maxHelper(root.right)); // we want to consider only >= 0
        maxi = Math.max(maxi, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}

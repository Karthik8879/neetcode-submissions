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
    public int maxDepth(TreeNode root) {
        // Base case
        if(root == null) {
            return 0;
        }
        // store left height wrt max height
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        // we have to consider max of both left and right and return
        return Math.max(left, right);
    }
}

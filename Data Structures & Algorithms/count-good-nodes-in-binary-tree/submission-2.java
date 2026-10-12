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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int maxSoFar) {
        // base case
        int cnt;
        if(root == null) return 0;
        if(root.val >= maxSoFar) {
            maxSoFar = root.val;
            cnt = 1;
        } else {
            cnt = 0;
        }
        cnt += helper(root.left, maxSoFar);
        cnt += helper(root.right, maxSoFar);
        return cnt;
    }
}

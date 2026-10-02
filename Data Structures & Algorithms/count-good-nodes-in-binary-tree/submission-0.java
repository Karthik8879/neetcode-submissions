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
        // base case
        if(root == null) return 0;
        return dfsHelper(root, root.val);
    }

    private int dfsHelper(TreeNode root, int maxi) {
        int cnt = 1;
        // base case
        if(root == null) return 0;
        if(root.val >= maxi) {
            maxi = root.val;
            cnt = 1;
        } else {
            cnt = 0;
        }
        cnt += dfsHelper(root.left, maxi);
        cnt += dfsHelper(root.right, maxi);
        return cnt;
    }
}

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
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }
        // left height
        int left = dfsHeight(root.left);
        if(left == -1) return -1;
        // right height
        int right = dfsHeight(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }


    // public boolean isBalanced(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return true;
    //     }
    //     int leftMax = maxHeight(root.left);
    //     int rightMax = maxHeight(root.right);
    //     if(Math.abs(leftMax - rightMax) > 1) return false;
    //     return isBalanced(root.left) && isBalanced(root.right);
    // }

    // private int maxHeight(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return 0;
    //     }
    //     // left
    //     int left = 1 + maxHeight(root.left);
    //     int right = 1 + maxHeight(root.right);
    //     return Math.max(left, right);
    // }
}

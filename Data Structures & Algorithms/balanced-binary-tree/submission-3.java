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

    class Custom{
        int height;
        boolean isBalanced;
        Custom(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        Custom ans = helper(root);
        return ans.isBalanced;
    }

    private Custom helper(TreeNode root) {
        if(root == null) {
            return new Custom(0, true);
        }
        // left height
        Custom left = helper(root.left);
        // right height
        Custom right = helper(root.right);

        int height = 1 + Math.max(left.height, right.height);

        boolean balanced = Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced;

        return new Custom(height, balanced);
    }

    // public boolean isBalanced(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return true;
    //     }
    //     return dfsHeight(root) != -1;
    // }

    // private int dfsHeight(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return 0;
    //     }
    //     // left height
    //     int left = dfsHeight(root.left);
    //     if(left == -1) return -1;
    //     // right height
    //     int right = dfsHeight(root.right);
    //     if(right == -1) return -1;
    //     if(Math.abs(left - right) > 1) return -1;
    //     return 1 + Math.max(left, right);
    // }


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

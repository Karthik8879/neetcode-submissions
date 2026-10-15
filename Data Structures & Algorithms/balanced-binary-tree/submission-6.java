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
        // base case
        if(root == null) return true;
        Custom ans = helper(root);
        return ans.isBalanced;
    }
    

    private Custom helper(TreeNode root) {
        // base case
        if(root == null) return new Custom(0, true);
        Custom left = helper(root.left);
        Custom right = helper(root.right);
        int height = 1 + Math.max(left.height, right.height);
        boolean balanced = Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced;
        return new Custom(height, balanced);
    }
}

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
        if(root == null) {
            return 0;
        }
        // left height
        int leftHeight = maxHeight(root.left);
        // right height
        int rightHeight = maxHeight(root.right);

        // store a diameter variable
        int diameter = leftHeight + rightHeight;

        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(sub, diameter);
    }

    private int maxHeight(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }
        // left height
        int left = 1 + maxHeight(root.left);
        // right height
        int right = 1 + maxHeight(root.right);
        return Math.max(left, right);
    }
}

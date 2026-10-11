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
        int left = heightHelper(root.left);
        int right = heightHelper(root.right);
        return Math.max(left + right, diameterOfBinaryTree(root.left) + diameterOfBinaryTree(root.right));
    }

    private int heightHelper(TreeNode root) {
        // base case
        if(root == null) return 0;
        return 1 + Math.max(heightHelper(root.left), heightHelper(root.right));
    }

    // public int diameterOfBinaryTree1(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return 0;
    //     }
    //     // left height
    //     int leftHeight = maxHeight1(root.left);
    //     // right height
    //     int rightHeight = maxHeight1(root.right);

    //     // store a diameter variable
    //     int diameter = leftHeight + rightHeight;

    //     int sub = Math.max(diameterOfBinaryTree1(root.left), diameterOfBinaryTree1(root.right));
    //     return Math.max(sub, diameter);
    // }

    // private int maxHeight1(TreeNode root) {
    //     // base case
    //     if(root == null) {
    //         return 0;
    //     }
    //     // left height
    //     int left = 1 + maxHeight(root.left);
    //     // right height
    //     int right = 1 + maxHeight(root.right);
    //     return Math.max(left, right);
    // }
}

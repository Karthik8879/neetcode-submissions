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
    int ans = 0, cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderHelper(root, k);
        return ans;
    }

    private void inorderHelper(TreeNode root, int k) {
        // base case
        if(root == null) return;
        inorderHelper(root.left, k);
        cnt++;
        if(cnt == k) {
            ans = root.val;
            return;
        } 
        inorderHelper(root.right, k);
    }
}

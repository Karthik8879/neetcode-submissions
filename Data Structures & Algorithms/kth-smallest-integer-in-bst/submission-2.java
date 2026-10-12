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
    int cnt = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        // i am going to do inorder traversal
        // because i am going to be getting sorted traversal
        // when i am going to have cnt == k -> return root.val
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root, int k) {
        // base case
        if(root == null) return;
        helper(root.left, k);
        cnt++;
        if(cnt == k) {
            ans = root.val;
            return;
        } 
        helper(root.right, k);
    }
}

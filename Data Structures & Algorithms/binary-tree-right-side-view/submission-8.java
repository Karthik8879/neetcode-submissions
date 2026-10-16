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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<Integer> res) {
        // base case
        if(root == null) return;
        if(depth == res.size()) res.add(root.val);
        helper(root.right, depth+1, res);
        helper(root.left, depth+1, res);
    }
}

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
    public int goodNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return 0;
        helper(root, Integer.MIN_VALUE, res);
        return cnt;
    }

    private void helper(TreeNode root, int maxVal, List<Integer> res) {
        // base case
        if(root == null) return;
        if(root.val >= maxVal) {
            maxVal = root.val;
            cnt++;
            res.add(root.val);
        }
        helper(root.left, maxVal, res);
        helper(root.right, maxVal, res);
    }
}

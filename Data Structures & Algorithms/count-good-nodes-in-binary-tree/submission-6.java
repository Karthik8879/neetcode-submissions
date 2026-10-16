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
        TreeNode root;
        int maxVal;
        Custom(TreeNode root, int maxVal) {
            this.root = root;
            this.maxVal = maxVal;
        }
    }
    public int goodNodes(TreeNode root) {
        // base case
        if(root == null) return 0;
        int cnt = 0;
        Queue<Custom> q = new LinkedList<>();
        q.add(new Custom(root, root.val));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Custom custom = q.poll();
                TreeNode node = custom.root;
                int maxVal = custom.maxVal;
                if(node.val >= maxVal) {
                    cnt++;
                }
                int newMaxVal = Math.max(maxVal, node.val);
                if(node.left != null) q.add(new Custom(node.left, newMaxVal));
                if(node.right != null) q.add(new Custom(node.right, newMaxVal));
            }
        }
        return cnt;
    }
}

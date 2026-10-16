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
        long minVal;
        long maxVal;
        Custom(TreeNode root, long minVal, long maxVal) {
            this.root = root;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // base case
        if(root == null) return true;
        Queue<Custom> q = new LinkedList<>();
        q.offer(new Custom(root, Long.MIN_VALUE, Long.MAX_VALUE));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Custom custom = q.poll();
                TreeNode node = custom.root;
                long minVal = custom.minVal;
                long maxVal = custom.maxVal;
                // cases
                if(node.val <= minVal) return false;
                if(node.val >= maxVal) return false;
                // populating the queue
                if(node.left != null) q.offer(new Custom(node.left, minVal, node.val));
                if(node.right != null) q.offer(new Custom(node.right, node.val, maxVal));
            }
        }
        return true;
    }
}

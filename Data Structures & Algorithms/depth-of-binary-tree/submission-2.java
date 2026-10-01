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

    public int maxDepth(TreeNode root) {
       // base case
       if(root == null) {
        return 0;
       }
       // Prepare a queue and add root node
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);

        // storing level that we are going to return
        int level = 0;

       // looping till we have we have traversed all level
       while(!q.isEmpty()) {
        // storing the size of queue because we are going to be adding and removing from queue so size changes
        int size = q.size();
        // looping through the size of the queue and poplating the queue and updating the level
        for(int i = 0; i < size; i++) {
            // storing the node
            TreeNode node = q.poll();
            // populating the q based on the left and right nodes of the node
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        // updating the level after each queue.size() traversal
        level++;
       }
       // returning the level
       return level;
    }

    public int maxDepth1(TreeNode root) {
        // Base case
        if(root == null) {
            return 0;
        }
        // store left height wrt max height
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        // we have to consider max of both left and right and return
        return Math.max(left, right);
    }
}

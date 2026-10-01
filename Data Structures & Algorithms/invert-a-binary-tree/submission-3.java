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

    public TreeNode invertTree(TreeNode root) {
        // base case
        if(root == null) {
            return  null;
        }
        // Make queue to add root --> and other elements
        Queue<TreeNode> q = new LinkedList<>();
        // adding root to the queue
        q.add(root);
        // start looping
        while(!q.isEmpty()) {
            // store the treenode
            TreeNode node = q.poll();

            // making use of temp to reverse
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // first level done now check if we are having to deal with other levels
            // so we are going to add them into queue if node.left != null and node.right != null

            if(node.left != null) q.offer(node.left);
            if(node.right  != null) q.offer(node.right);

        }
        // return the root after this is done
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }


    public TreeNode invertTree1(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

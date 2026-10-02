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
        List<Integer> temp = new ArrayList<>();
        helper(root, 0, temp);
        return temp;
    }

    private void helper(TreeNode root, int depth, List<Integer> temp) {
        // base case
        if(root == null) return;
        if(depth == temp.size()) temp.add(root.val);
        helper(root.right, depth+1, temp);
        helper(root.left, depth+1, temp);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        if(root == null) {
            return temp;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == size - 1) {
                    temp.add(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return temp;  
    }
}

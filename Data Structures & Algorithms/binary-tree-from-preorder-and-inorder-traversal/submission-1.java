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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if(inorder.length != preorder.length) return null;
        HashMap<Integer, Integer> inorderHm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderHm.put(inorder[i], i);
        }
        return builderHelper(preorder, 0, inorder.length-1, inorderHm);
    }

    private TreeNode builderHelper(int[] preorder, int left, int right, HashMap<Integer, Integer> inorderHm) {
        if(left > right) return null;
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderHm.get(rootVal);
        root.left = builderHelper(preorder, left, mid-1, inorderHm);
        root.right = builderHelper(preorder, mid+1, right, inorderHm);
        return root;
    }
}

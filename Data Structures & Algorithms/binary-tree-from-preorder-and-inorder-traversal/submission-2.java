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
        if(preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1, hm);
    }

    private TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> hm) {
        if(start > end) return null;
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int mid = hm.get(rootVal);
        root.left = helper(preorder, start, mid-1, hm);
        root.right = helper(preorder, mid+1, end, hm);
        return root;
    }
}

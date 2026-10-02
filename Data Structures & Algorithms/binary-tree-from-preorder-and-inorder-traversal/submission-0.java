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
        HashMap<Integer, Integer> iMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            iMap.put(inorder[i], i);
        }
        return buildHelper(preorder, 0, inorder.length-1, iMap);
    }

    private TreeNode buildHelper(int[] preorder, int left, int right, HashMap<Integer, Integer> iMap) {
        if(left > right) return null;
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int mid = iMap.get(rootVal);
        root.left = buildHelper(preorder, left, mid-1, iMap);
        root.right = buildHelper(preorder, mid+1, right, iMap);
        return root;
    }
}

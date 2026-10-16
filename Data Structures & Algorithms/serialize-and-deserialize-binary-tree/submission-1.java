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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }

    private void helperSerialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        helperSerialize(node.left, sb);
        helperSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(",");
        List<String> list = Arrays.asList(values);
        Queue<String> q = new LinkedList<>(list);
        return helperDeserialize(q);
    }

    private TreeNode helperDeserialize(Queue<String> q) {
        String val = q.poll();
        if(val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helperDeserialize(q);
        node.right = helperDeserialize(q);
        return node;
    }
}

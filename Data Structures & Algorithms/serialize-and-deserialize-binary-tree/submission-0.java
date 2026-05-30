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

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = "null".equals(array[0]) ? null : new TreeNode(Integer.valueOf(array[0]));
        if (head != null) queue.offer(head);
        int i = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            i++;
            TreeNode left = "null".equals(array[i]) ? null : new TreeNode(Integer.valueOf(array[i]));
            node.left = left;
            if (left != null) {
                queue.offer(left);
            }

            i++;
            TreeNode right = "null".equals(array[i]) ? null : new TreeNode(Integer.valueOf(array[i]));
            node.right = right;
            if (right != null) {
                queue.offer(right);
            }
        }

        return head;
    }
}

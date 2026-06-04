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
    public boolean isBalanced(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            node.val = 1;
            return true;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        int ld = node.left == null ? 0 : node.left.val;
        int rd = node.right == null ? 0 : node.right.val;
        boolean self = Math.abs(ld - rd) <= 1;

        node.val = Math.max(ld, rd) + 1;
        return left && right && self;
    }
}

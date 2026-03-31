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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        dfs(root, ans);

        return ans[0];
    }

    private int dfs(TreeNode node, int[] ans) {
        if (node.left == null && node.right == null) {
            ans[0] = Math.max(ans[0], node.val);
            return node.val;
        }

        int left = node.left == null ? 0 : dfs(node.left, ans);
        int right = node.right == null ? 0 : dfs(node.right, ans);

        int max =  Math.max(node.val, Math.max(left + right + node.val, Math.max(left + node.val, right + node.val)));
        ans[0] = Math.max(ans[0], max);
        return Math.max(node.val, Math.max(left + node.val, right + node.val));
    }
}

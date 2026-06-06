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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int prel, int prer, int inl, int inr) {
        if (prel > prer) return null;

        TreeNode root = new TreeNode(preorder[prel]);
        int mid = map.get(preorder[prel]);
        int len = mid - inl;
        root.left = dfs(preorder, prel + 1, prel + len, inl, mid - 1);
        root.right = dfs(preorder, prel + len + 1, prer, mid + 1, inr);

        return root;
    }
}

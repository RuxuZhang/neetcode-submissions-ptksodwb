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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > Math.max(p.val, q.val)) {
            return find(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return find(root.right, p, q);
        } else {
            return root;
        }
    }

    private void findP(TreeNode node, TreeNode p, Stack<TreeNode> stack) {
        stack.push(node);

        if (node.val == p.val) {
            return;
        } else if (node.val > p.val && node.left != null) {
            findP(node.left, p, stack);
        } else if (node.right != null){
            findP(node.right, p, stack);
        }
    }

    private boolean findQ(TreeNode node, TreeNode q) {
        if (node == null) {
            return false;
        }

        if (node.val == q.val) {
            return true;
        }

        if (node.val > q.val) {
            return findQ(node.left, q);
        } else {
            return findQ(node.right, q);
        }
    }
}

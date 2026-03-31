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
        Stack<TreeNode> stack = new Stack<>();;
        findP(root, p, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (findQ(node, q)) {
                return node;
            }
        }
        return null;
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

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
    int count = 0;
    public int dfs(TreeNode root, int maxSoFar) {
        if(root == null) {
            return 0;
        }
        int res = root.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, root.val);
        res+= dfs(root.left, maxSoFar);
        res+= dfs(root.right, maxSoFar);
        return res;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
}

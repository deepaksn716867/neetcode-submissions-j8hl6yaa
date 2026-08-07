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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> levels = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (level.size() >= 1) {
                levels.add(level);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> level : levels) {
            result.add(level.get(level.size() - 1));
        }
        return result;
    }
}

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
    public int[] heightOfTree(TreeNode root) {
        if(root == null) {
            return new int[]{1, 0};
        }

        int[] leftHeight = heightOfTree(root.left);
        int[] rightHeight = heightOfTree(root.right);
        boolean isBalanced = leftHeight[0] == 1 && 
                        rightHeight[0] == 1 && 
                            (Math.abs(leftHeight[1] - rightHeight[1]) <= 1);
        return new int[]{isBalanced ? 1 : 0, Math.max(leftHeight[1], rightHeight[1]) + 1};
    }
    public boolean isBalanced(TreeNode root) {
        return heightOfTree(root)[0] == 1;
    }
}

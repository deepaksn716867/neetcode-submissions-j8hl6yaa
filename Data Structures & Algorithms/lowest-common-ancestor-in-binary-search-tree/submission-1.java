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
    // The iterative solve from the solution is easiest.
    public List<TreeNode> findBST(TreeNode root, TreeNode find) {
        if(root == null) {
            return null;
        }
        if(root.val == find.val) {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            return path;
        }
        List<TreeNode> path;
        if(root.val > find.val) {
            path = findBST(root.left, find);
        } else {
            path = findBST(root.right, find);
        }
        path.add(root);
        return path;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathForP = findBST(root, p);
        List<TreeNode> pathForQ = findBST(root, q);
         Collections.reverse(pathForP); 
         Collections.reverse(pathForQ);
         int i = 0, j = 0;
         while(i < pathForP.size() && j < pathForQ.size()) {
            if(pathForP.get(i).val == pathForQ.get(j).val) {
                i++;
                j++;
                continue;
            } else {
                break;
            }
         }
         return pathForP.get(--i);
    }
}

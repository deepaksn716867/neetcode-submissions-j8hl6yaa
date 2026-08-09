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
/**
Pretty tough problem, not easily intutive so memorize as an algo like below. Asked neetcode claude and it gave the recursion simulation. In order to easily remember while calling the recursion for left subtree and right subtree. Rember it as elements in-order array before the mid (l, mid - 1) are the left subtree and elements after the mid (mid + 1, r) are right subtree.

Absolutely! Let me trace through the example step by step.

**Input:**
```
preorder = [1,2,3,4]
inorder = [2,1,3,4]
indices = {2:0, 1:1, 3:2, 4:3}
```

---

## Trace Execution

**Call 1:** `dfs(preorder, 0, 3)` — Build entire tree
```
pre_idx = 0
l = 0, r = 3
root_val = preorder[0] = 1
mid = indices[1] = 1
inorder range: [2|1|3,4]
                l   mid  r
├─ left: dfs(preorder, 0, 0)  — indices 0 to 0 in inorder
└─ right: dfs(preorder, 2, 3) — indices 2 to 3 in inorder
```

**Call 2:** `dfs(preorder, 0, 0)` — Build left subtree of 1
```
pre_idx = 1
l = 0, r = 0
root_val = preorder[1] = 2
mid = indices[2] = 0
inorder range: [2|_|_]
               l,mid  r
├─ left: dfs(preorder, 0, -1)  — returns null (l > r)
└─ right: dfs(preorder, 1, 0)  — returns null (l > r)
Creates node with value 2
```

**Call 3:** `dfs(preorder, 0, -1)` — Invalid range
```
l > r, return null
```

**Call 4:** `dfs(preorder, 1, 0)` — Invalid range
```
l > r, return null
```

**Call 5:** `dfs(preorder, 2, 3)` — Build right subtree of 1
```
pre_idx = 2
l = 2, r = 3
root_val = preorder[2] = 3
mid = indices[3] = 2
inorder range: [_|_|3|4]
                     l  r
├─ left: dfs(preorder, 2, 1)  — returns null (l > r)
└─ right: dfs(preorder, 3, 3) — indices 3 to 3 in inorder
Creates node with value 3
```

**Call 6:** `dfs(preorder, 2, 1)` — Invalid range
```
l > r, return null
```

**Call 7:** `dfs(preorder, 3, 3)` — Build right subtree of 3
```
pre_idx = 3
l = 3, r = 3
root_val = preorder[3] = 4
mid = indices[4] = 3
inorder range: [_|_|_|4]
                     l,r
├─ left: dfs(preorder, 3, 2)  — returns null (l > r)
└─ right: dfs(preorder, 4, 3) — returns null (l > r)
Creates node with value 4
```

---

## Result Tree

```
       1
      /
     2
      \
       3
        \
         4
```

**Key observations:**
- `pre_idx` increments **globally** across all recursive calls (0 → 1 → 2 → 3)
- `l` and `r` narrow down based on `mid` position in inorder
- The **count** of elements in inorder automatically aligns with preorder consumption
- When `l > r`, we've accounted for all nodes in that subtree, return null

Does this clarify how the recursion builds the tree?
**/
class Solution {
    int pre_idx = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);
        int mid = indices.get(root_val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}

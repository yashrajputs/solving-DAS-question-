/**************************************************************** JAVA *************************************************************/
//Approach - Recursion
//T.C : O(n)
//S.C : O(1) Auxiliary space (But O(n) system recursion stack space)


class Solution {
    int solve(TreeNode root, int val) {
        
        if(root == null) {
            return 0;
        }
        val = (2 * val) + root.val;

        if(root.left == null && root.right == null) {
            return val;
        }
        return solve(root.left, val) + solve(root.right, val);
    }
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
        
    }
}

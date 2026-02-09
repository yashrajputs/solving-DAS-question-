/************************************************************ JAVA ************************************************************/
//Approach : Using (BST)
//T.C : O(n)
//S.C : O(n)



class Solution {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return createBalancedBST(0,list.size()-1);
    }

    void inorder(TreeNode root) {
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    TreeNode createBalancedBST(int start, int end) {
        if(start > end)
            return null;
        int mid = start + (end-start)/2;
        TreeNode left = createBalancedBST(start, mid-1);
        TreeNode right = createBalancedBST(mid+1, end);
        TreeNode root = new TreeNode(list.get(mid), left, right);
        return root;
    }
}

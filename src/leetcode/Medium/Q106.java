package leetcode.Medium;

import leetcode.TreeNode;

public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder,0,n - 1,postorder,0,n - 1);
    }
    public TreeNode build(int[] inorder,int lo1,int hi1,int[] postorder,int lo2,int hi2){
        if(lo1 > hi1){
            return null;
        }
        TreeNode root = new TreeNode(postorder[hi2]);
        int i = lo1;
        for(;i <= hi1;i ++){
            if(inorder[i] == postorder[hi2]){
                break;
            }
        }
        root.left = build(inorder,lo1,i - 1,postorder,lo2,lo2 + i - 1 - lo1);
        root.right = build(inorder,i + 1,hi1,postorder,lo2 + i - lo1,hi2 - 1);
        return root;
    }
}

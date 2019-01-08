package leetcode.Easy;

import leetcode.TreeNode;

public class Q111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return min(root);
    }
    public int min(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.right == null){
            return min(root.left) + 1;
        }else if(root.left == null){
            return min(root.right) + 1;
        }else{
            return Math.min(min(root.right),min(root.left)) + 1;
        }
    }
}


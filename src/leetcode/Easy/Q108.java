package leetcode.Easy;

import leetcode.TreeNode;

public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return devide(nums,0,nums.length - 1);
    }
    public TreeNode devide(int[] nums,int lo,int hi){
        if(lo > hi){
            return null;
        }
        if(lo == hi){
            return new TreeNode(nums[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = devide(nums,lo,mid - 1);
        node.right = devide(nums,mid + 1,hi);
        return node;
    }
}

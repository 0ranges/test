package leetcode.Medium;

public class Q260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int sum = 0;
        for(int n : nums){
            sum ^= n;
        }
        int flag = sum & (-sum);
        for(int n : nums){
            if((n & flag) == 0){
                res[0] ^= n;
            }else{
                res[1] ^= n;
            }
        }
        return res;
    }
}

package leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n,1);
            }
        }
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for(int n : map.keySet()){
            if(map.get(n) > len / 3){
                res.add(n);
            }
        }
        return res;
    }
}

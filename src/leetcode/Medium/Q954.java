package leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class Q954 {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : A){
            if (!map.containsKey(n)) {
                map.put(n,1);
            } else {
                map.put(n,map.get(n) + 1);
            }
        }
        Arrays.sort(A);
        if(map.containsKey(0)){
            if(map.get(0) % 2 != 0) {
                return false;
            }else{
                map.remove(0);
            }
        }
        for(int i = 0;i < A.length;i++){
            if(map.containsKey(A[i])){
                if(map.containsKey(A[i] * 2)){
                    if(map.get(A[i] * 2) == 1){
                        map.remove(A[i] * 2);
                    }else{
                        map.put(A[i] * 2,map.get(A[i] * 2) - 1);
                    }
                    if(map.get(A[i]) == 1){
                        map.remove(A[i]);
                    }else{
                        map.put(A[i],map.get(A[i]) - 1);
                    }
                }
            }
        }
        return map.isEmpty();
    }
}

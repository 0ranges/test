package leetcode.Other;

public class Q002 {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length == 0){
            return res;
        }
        int min = Integer.MAX_VALUE;
        for(String str : strs){
            min = Math.min(min, str.length());
        }
        for(int i = 1;i <= min;i++){
            char c = strs[0].charAt(i - 1);
            for(String str : strs){
                if(str.charAt(i - 1) != c){
                    return res;
                }
            }
            res += c;
        }
        return res;
    }
}

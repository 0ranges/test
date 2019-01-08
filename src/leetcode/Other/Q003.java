package leetcode.Other;

public class Q003 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0;i < s1.length();i++){
            count1[s1.charAt(i) - 'a'] ++;
            count2[s2.charAt(i) - 'a'] ++;
        }
        for(int i = 0;i <= s2.length() - s1.length();i++){
            boolean flag = true;
            for(int j = 0;j < 26;j++){
                if(count1[j] != count2[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
            count2[s2.charAt(i) - 'a'] --;
            if(i < s2.length() - s1.length()) {
                count2[s2.charAt(i + s1.length()) - 'a']++;
            }
        }
        return false;
    }
}

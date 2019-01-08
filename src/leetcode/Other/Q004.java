package leetcode.Other;

public class Q004 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] a = new int[len1];
        int[] b = new int[len2];
        int[] res = new int[len1 + len2 + 1];
        for(int i = 0; i < len1;i++){
            a[i] = num1.charAt(len1 - 1 - i) - '0';
        }
        for(int i = 0; i < len2;i++){
            b[i] = num2.charAt(len2 - 1 - i) - '0';
        }
        for(int i = 0;i < len1;i++){
            int jw = 0;
            if(a[i] != 0) {
                for (int j = 0; j < len2; j++) {
                    res[i + j] += a[i] * b[j] + jw;
                    jw = res[i + j] / 10;
                    res[i + j] %= 10;
                }
                res[i + len2] = jw;
            }
        }
        String str = "";
        int index = len1 + len2;
        for(;index >= 0;index --){
            if(res[index] != 0){
                break;
            }
        }
        for(;index >= 0;index --){
            str += res[index];
        }
        return str == "" ? "0" : str;
    }
}

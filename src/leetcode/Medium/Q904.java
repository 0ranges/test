package leetcode.Medium;

public class Q904 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{0,0,1,1}));
    }
    public static int totalFruit(int[] tree) {
        int n = tree.length;
        if(n <= 2){
            return n;
        }
        int index = 1;
        int kind_1 = tree[0];
        int kind_2 = tree[0];
        int res = 1;
        int result = res;
        while(index < n){
            if(tree[index] != kind_1){
                kind_2 = tree[index];
                break;
            }
            index ++;
        }
        if(index == n){
            return n;
        }else{
            index ++;
            res = index;
            while(index < n){
                int t = tree[index];
                if(t != kind_1 && t != kind_2){
                    result = Math.max(res, result);
                    res = 1;
                    kind_1 = t;
                    kind_2 = tree[index - 1];
                    int index_ = index - 1;
                    while(index_ >= 0 && tree[index_] == kind_2){
                        index_ --;
                        res ++;
                    }
                }else{
                    res ++;
                }
                index ++;
            }
            return Math.max(res, result);
        }
    }
}

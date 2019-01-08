package leetcode.Hard;

public class Q037 {
    public static void main(String[] args) throws InterruptedException {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
    public static void print(char[][] board){
        for(int i = 0;i < 9;i ++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solveSudoku(char[][] board) throws InterruptedException {
        solveSudoku1(board);
    }
    public static boolean solveSudoku1(char[][] board) {
        for(int i = 0;i < 9;i ++){
            for(int j = 0;j < 9;j ++){
                if(board[i][j] == '.'){
                    for(char k = '1';k <= '9';k ++){
                        board[i][j] = k;
                        if(judge(board,i,j) && solveSudoku1(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean judge(char[][] board,int i,int j){
        for(int k = 0;k < 9;k ++){
            if(board[i][j] == board[i][k] && k != j){
                return false;
            }
            if(board[i][j] == board[k][j] && k != i){
                return false;
            }
        }
        int i_ = i / 3 * 3;
        int j_ = j / 3 * 3;
        for(int k1 = i_;k1 < i_ + 3;k1 ++){
            for(int k2 = j_;k2 < j_ + 3;k2 ++){
                if(board[i][j] == board[k1][k2] && !(i == k1 && j == k2)){
                    return false;
                }
            }
        }
        return true;
    }
}

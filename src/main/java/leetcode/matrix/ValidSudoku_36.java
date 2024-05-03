package leetcode.matrix;

public class ValidSudoku_36 {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {

            boolean check = true;

            for(int x = 0; x < 9; x++){
                boolean[] col = new boolean[10];
                boolean[] row = new boolean[10];
                for(int y = 0; y < 9; y++){
                    if(board[x][y] != '.'){
                        int num = Character.getNumericValue(board[x][y]);
                        if(row[num] == true){
                            return false;
                        }else{
                            row[num] = true;
                        }
                    }
                    if(board[y][x] != '.'){
                        int num = Character.getNumericValue(board[y][x]);
                        if(col[num] == true){
                            return false;
                        }else{
                            col[num] = true;
                        }
                    }
                }

                for(int i = 0; i < 9; i+=3){
                    for(int j = 0; j < 9; j+=3){
                        boolean[] square = new boolean[10];
                        for(int a = i; a < i+3; a++){
                            for(int b = j; b < j+3; b++){
                                if(board[a][b] != '.'){
                                    int num = Character.getNumericValue(board[a][b]);
                                    if(square[num] == true){
                                        return false;
                                    }else{
                                        square[num] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}

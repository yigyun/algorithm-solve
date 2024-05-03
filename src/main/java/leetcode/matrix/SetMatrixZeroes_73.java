package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes_73 {

    static class Solution {
        public void setZeroes(int[][] matrix) {

            List<Integer> col = new ArrayList<>();
            List<Integer> row = new ArrayList<>();

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(matrix[i][j] == 0){
                        col.add(j);
                        row.add(i);
                    }
                }
            }

            for(int i = 0; i < matrix.length; i++){
                if(row.contains(i)){
                    matrix[i] = new int[matrix[0].length];
                    continue;
                }
                for(int j = 0; j < matrix[0].length; j++){
                    if(col.contains(j))
                        matrix[i][j] = 0;
                }
            }


        }
    }

}

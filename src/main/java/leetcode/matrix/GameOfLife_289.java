package leetcode.matrix;

import java.util.*;

public class GameOfLife_289 {

    static class Solution {

        private static final int[][] MOVES = {{0,1},{1,1},{1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};

        public void gameOfLife(int[][] board) {
            validateInput(board);
            Set<List<Integer>> liveCells = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 1) {
                        liveCells.add(List.of(row, col));
                    }
                }
            }
            Set<List<Integer>> nextState = generateNextState(liveCells, board.length, board[0].length);
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    board[row][col] = nextState.contains(List.of(row, col)) ? 1 : 0;
                }
            }
        }

        private Set<List<Integer>> generateNextState(Set<List<Integer>> liveCells, int rows, int cols) {
            Set<List<Integer>> nextState = new HashSet<>();
            Map<List<Integer>, Integer> map = new HashMap<>();
            for (List<Integer> liveCell : liveCells) {
                for (int[] move : MOVES) {
                    int nextRow = liveCell.get(0) + move[0];
                    int nextCol = liveCell.get(1) + move[1];
                    List<Integer> neighbor = List.of(nextRow, nextCol);
                    if (canMove(rows, cols, nextRow, nextCol)) {
                        map.put(neighbor, map.getOrDefault(neighbor, 0) + 1);
                    }
                }
            }
            for (List<Integer> cell : map.keySet()) {
                int neighbors = map.get(cell);
                if (neighbors == 3 || (neighbors == 2 && liveCells.contains(cell))) {
                    nextState.add(cell);
                }
            }
            return nextState;
        }

        private boolean canMove(int rows, int cols, int row, int col) {
            return 0 <= row && row < rows && 0 <= col && col < cols;
        }

        private void validateInput(int[][] board) {
            if (board == null || board.length == 0) {
                throw new IllegalArgumentException("Invalid input!");
            }
        }
    }
}

import java.util.*;
/**
 *
 https://neetcode.io/problems/valid-sudoku
 Valid Sudoku
 You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

 Each row must contain the digits 1-9 without duplicates.
 Each column must contain the digits 1-9 without duplicates.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 Return true if the Sudoku board is valid, otherwise return false

 Note: A board does not need to be full or be solvable to be valid.

 Example 1:



 Input: board =
 [["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

 Output: true
 Example 2:

 Input: board =
 [["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","1",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

 Output: false
 Explanation: There are two 1's in the top-left 3x3 sub-box.

 Constraints:

 board.length == 9
 board[i].length == 9
 board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
    /**
     * going over the whole board 3 times to check for duplicates.
     * 1 - all rows
     * 2 - all columns
     * 3 - all squares
     *
     * Runtime Complexity: O(n) --- 3n
     * Space Complexity: O(9) - to track the duplicates
     *
     */
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true ;
        for( int i=0; i< board.length; i++) {
            valid = valid && isValid(board, i, i+1, 0, board[i].length);
            valid = valid &&  isValid(board, 0, board[i].length, i, i+1);

            if(i%3==0 && i+1<board.length) {
                for( int j=0; j<board.length; j+=3) {
                    System.out.println("i "+i+", j "+j);
                    valid = valid && isValid(board, i, i+3, j, j+3);
                }
            }
        }
        return valid;
    }

    // End is exclusive
    public boolean isValid(char[][] board, int rStart, int rEnd, int cStart, int cEnd) {
        int[] check = new int[10];
        System.out.println("isValid:"+rStart);
        for(int i=rStart; i<rEnd; i++) {
            for (int j=cStart; j<cEnd; j++) {
                char c = board[i][j];
                if(c=='.') {
                    continue;
                } else {
                    check[c-'0']++;
                    if(check[c-'0']>1){
                        System.out.println(check[c-'0']);
                        return false;
                    }
                }

            }
        }
        return true;
    }

    /**
     * From NC
     * Tracking row, column and square level duplicates using hashmap with hashset
     *
     * Runtime : O(n) --- 1n
     * Space: O(n)
     */
    public boolean isValidSudokuV2(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();  // key = (r / 3) * 3 + c / 3

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (cell == '.') {
                    continue;
                }
                if (rows.getOrDefault(r, new HashSet<>()).contains(cell)
                        || cols.getOrDefault(c, new HashSet<>()).contains(cell)
                        || squares.getOrDefault((r / 3) * 3 + c / 3, new HashSet<>()).contains(cell)) {
                    return false;
                }
                cols.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
                rows.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
                squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(cell);
            }
        }
        return true;
    }


}

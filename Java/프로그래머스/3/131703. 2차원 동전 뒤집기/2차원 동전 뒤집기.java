import java.util.*;
class Solution {
    int[][] arr;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        int[][] diff = new int[beginning.length][beginning[0].length];
        for (int i = 0; i < beginning.length; i++) {
            for (int j = 0; j < beginning[i].length; j++) {
                if (beginning[i][j] != target[i][j]) {
                    diff[i][j] = 1;
                } else {
                    diff[i][j] = 0;
                }
            }
        }

        int min = Math.min(flip1(diff), flip2(diff));

        flipRow(diff, 0);
        int min2 = Math.min(flip1(diff), flip2(diff)) + 1;

        answer = Math.min(min, min2);
        return answer;
    }

    void copyArr(int[][] beginning) {
        arr = new int[beginning.length][beginning[0].length];
        for (int i = 0; i < beginning.length; i++) {
            arr[i] = beginning[i].clone();
        }
    }

    int flip1(int[][] diff) {
        copyArr(diff);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1) {
                flipRow(arr, i);
                count++;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 1) {
                flipCol(arr, i);
                count++;
            }
        }

        if (Arrays.stream(arr).flatMapToInt(Arrays::stream).noneMatch(x -> x == 1)) {
            return count;
        }

        return -1;
    }

    int flip2(int[][] diff) {
        copyArr(diff);
        int count = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 1) {
                flipCol(arr, i);
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1) {
                flipRow(arr, i);
                count++;
            }
        }
        if (Arrays.stream(arr).flatMapToInt(Arrays::stream).noneMatch(x -> x == 1)) {
            return count;
        }

        return -1;
    }

    void flipCol(int[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            board[i][col] ^= 1;
        }
    }

    void flipRow(int[][] board, int row) {
        for (int i = 0; i < board[0].length; i++) {
            board[row][i] ^= 1;
        }
    }
}
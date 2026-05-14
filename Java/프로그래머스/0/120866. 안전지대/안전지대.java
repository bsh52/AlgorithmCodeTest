class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            int x = i + k;
                            int y = j + l;
                            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 0) {
                                board[x][y] = -1;
                            }
                        }
                    }
                }
            }
        }

        for (int[] ints : board) {
            for (int i : ints) {
                if (i == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
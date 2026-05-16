class Solution {
    int[] dh = {0, 1, -1, 0};
    int[] dw = {1, 0, 0, -1};
    int h_check, w_check, count = 0;

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        dfs(board, h, w);
        answer = count;
        return answer;
    }

    void dfs(String[][] board, int h, int w) {
        int n = board.length;

        for (int i = 0; i < 4; i++) {
            h_check = h + dh[i];
            w_check = w + dw[i];
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
    }
}
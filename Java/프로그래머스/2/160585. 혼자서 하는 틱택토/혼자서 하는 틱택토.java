class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                } else if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }
        if (xCount > oCount) {
            return 0;
        }
        if (oCount > xCount + 1) {
            return 0;
        }
        if (isComplete(board, 'O')) {
            if (oCount == xCount) {
                return 0;
            }
        }
        if (isComplete(board, 'X')) {
            if (oCount == xCount + 1) {
                return 0;
            }
        }
        return answer;
    }

    boolean isComplete(String[] board, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length(); i++) {
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }

        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }

        return false;
    }
}
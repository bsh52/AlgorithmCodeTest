class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean[][] check = new boolean[m][n];
        String[][] boardMatrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardMatrix[i][j] = board[i].substring(j, j + 1);
            }
        }

        while (true) {
            int count = checkX(boardMatrix);
            checkFour(boardMatrix, check, m, n);
            changeBlock(boardMatrix, check, m, n);
            dropBlock(boardMatrix, check, m, n);
            int count2 = checkX(boardMatrix);
            if (count == count2) {
                break;
            }
        }

        answer = checkX(boardMatrix);

        return answer;
    }

    int checkX(String[][] boardMatrix) {
        int count = 0;
        for (String[] row : boardMatrix) {
            for (String col : row) {
                if (col.equals("-")) {
                    count++;
                }
            }
        }
        return count;
    }

    void checkFour(String[][] boardMatrix, boolean[][] check, int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                String current = boardMatrix[i][j];
                if (current.equals(boardMatrix[i][j + 1]) && current.equals(boardMatrix[i + 1][j]) && current.equals(boardMatrix[i + 1][j + 1])) {
                    check[i][j] = true;
                    check[i + 1][j] = true;
                    check[i][j + 1] = true;
                    check[i + 1][j + 1] = true;
                }
            }
        }
    }

    void changeBlock(String[][] boardMatrix, boolean[][] check, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    boardMatrix[i][j] = "-";
                }
            }
        }
    }

    void dropBlock(String[][] boardMatrix, boolean[][] check, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j > 0; j--) {
                String current = boardMatrix[j][i];
                if (!current.equals("-")) {
                    continue;
                }
                for (int k = j - 1; k >= 0; k--) {
                    String next = boardMatrix[k][i];
                    if (!next.equals("-")) {
                        boardMatrix[j][i] = next;
                        boardMatrix[k][i] = current;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                if (boardMatrix[i][j].equals("-")) {
                    check[i][j] = true;
                } else {
                    check[i][j] = false;
                }
            }
        }
    }
}
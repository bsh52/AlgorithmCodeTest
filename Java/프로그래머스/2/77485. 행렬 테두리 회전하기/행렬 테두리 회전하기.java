class Solution {
    int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = i * matrix[0].length + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] range = queries[i];
            answer[i] = rotate(matrix, range);
        }

        return answer;
    }

    int rotate(int[][] matrix, int[] range) {
        int startRow = range[0] - 1;
        int endRow = range[2] - 1;
        int startCol = range[1] - 1;
        int endCol = range[3] - 1;

        int tmp = matrix[startRow][startCol];
        int min = Integer.MAX_VALUE;

        for (int i = startCol + 1; i <= endCol; i++) {
            int current = matrix[startRow][i];
            min = Math.min(min, Math.min(tmp, current));
            matrix[startRow][i] = tmp;
            tmp = current;
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            int current = matrix[i][endCol];
            min = Math.min(min, Math.min(tmp, current));
            matrix[i][endCol] = tmp;
            tmp = current;
        }

        for (int i = endCol - 1; i >= startCol; i--) {
            int current = matrix[endRow][i];
            min = Math.min(min, Math.min(tmp, current));
            matrix[endRow][i] = tmp;
            tmp = current;
        }

        for (int i = endRow - 1; i >= startRow; i--) {
            int current = matrix[i][startCol];
            min = Math.min(min, Math.min(tmp, current));
            matrix[i][startCol] = tmp;
            tmp = current;
        }

        return min;
    }
}
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (int) Math.ceil((double) n / w);
        int[][] arr = new int[row][w];
        int count = 1;
        int[] target = new int[2];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < w; j++) {
                if (count > n) {
                    break;
                }
                if (i % 2 == 0) {
                    if (count == num) {
                        target = new int[] {i, j};
                    }
                    arr[i][j] = count++;
                } else {
                    if (count == num) {
                        target = new int[] {i, w - j - 1};
                    }
                    arr[i][w - j - 1] = count++;
                }
            }
        }

        for (int i = row-1; i >= 0; i--) {
            if (arr[i][target[1]] == 0) {
                continue;
            }
            answer++;
            if (arr[i][target[1]] == num) {
                break;
            }
        }

        return answer;
    }
}
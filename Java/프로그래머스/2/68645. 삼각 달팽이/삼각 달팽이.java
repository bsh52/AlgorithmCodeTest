class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] tri = new int[n][n];
        int x = -1, y = 0, num = 1, index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        for (int[] arr : tri) {
            for (int i : arr) {
                if (i == 0) {
                    break;
                }
                answer[index++] = i;
            }
        }
        
        return answer;
    }
}
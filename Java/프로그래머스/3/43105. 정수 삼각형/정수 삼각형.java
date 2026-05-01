import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        arr[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            arr[i][0] = arr[i - 1][0] + triangle[i][0];

            for (int j = 1; j <= i; j++) {
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
            }
        }

        int[] max = arr[arr.length - 1];
        Arrays.sort(max);
        answer = max[max.length - 1];
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int answer = 1;
        int point = routes[0][1];
        for (int[] route : routes) {
            if (route[0] > point) {
                answer++;
                point = route[1];
            }
        }
        return answer;
    }
}
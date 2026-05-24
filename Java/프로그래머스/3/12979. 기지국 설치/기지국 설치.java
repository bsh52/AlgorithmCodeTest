import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w * 2 + 1;
        int start = 0;
        for (int station : stations) {
            answer += (station - 1 - w - start + w * 2) / range;
            start = station + w;
        }
        answer += (n - start + w * 2) / range;

        return answer;
    }
}
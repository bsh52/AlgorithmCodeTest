import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long min = 0;
        long max = times[times.length - 1] * (long) n;
        Arrays.sort(times);
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
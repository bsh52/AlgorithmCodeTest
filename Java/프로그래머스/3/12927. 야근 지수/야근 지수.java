import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        while (n > 0) {
            int temp = pq.poll();
            if (temp == 0) break;
            temp--;
            n--;
            pq.offer(temp);
        }
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            answer += (long) temp * temp;
        }
        return answer;
    }
}
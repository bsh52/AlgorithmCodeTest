import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        long sum1 = q1.stream().mapToInt(Integer::intValue).sum();
        long sum2 = q2.stream().mapToInt(Integer::intValue).sum();

        while (sum1 != sum2) {
            if (queue1.length + queue2.length + 1 < answer) {
                return -1;
            }
            if (sum1 > sum2) {
                int a = q1.poll();
                q2.offer(a);
                sum1 -= a;
                sum2 += a;
            } else if (sum1 < sum2) {
                int a = q2.poll();
                q1.offer(a);
                sum2 -= a;
                sum1 += a;
            } else {
                return answer;
            }
            answer++;
        }
        return answer;
    }
}
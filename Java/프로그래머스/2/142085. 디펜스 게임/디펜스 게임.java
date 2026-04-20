import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            queue.add(enemy[i]);

            if (n < 0) {
                if (k > 0) {
                    n += queue.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}
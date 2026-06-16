import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        int target = n + 1;
        int[] order = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n / 3; i++) {
            int card = cards[i];
            int pair = target - card;
            order[card] = i;
            visited[card] = true;

            if (visited[pair]) {
                pq.offer(0);
            }
        }

        for (int i = n / 3; i < n; i++) {
            int card = cards[i];
            int pair = target - card;
            order[card] = i;
            visited[card] = true;

            if (visited[pair]) {
                if (order[pair] < n / 3) {
                    pq.offer(1);
                } else {
                    pq.offer(2);
                }
            }

            if (i % 2 == 1) {
                if (!pq.isEmpty()) {
                    int cost = pq.poll();
                    if (coin >= cost) {
                        coin -= cost;
                        answer++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
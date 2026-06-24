import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int nowServer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < players.length; i++) {
            if (queue.size() >= k) {
                int remove = queue.poll();
                nowServer -= remove;
            }
            int need = Math.max(0, players[i] / m - nowServer);
            nowServer += need;
            answer += need;
            queue.add(need);
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }

        int max = 0;
        for (int d : distance) {
            max = Math.max(max, d);
        }

        for (int d : distance) {
            if (d == max) answer++;
        }

        return answer;
    }
}
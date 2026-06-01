import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        boolean[] visited = new boolean[n+1];
        int[] time = new int[n+1];
        Arrays.fill(time, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        visited[destination] = true;
        time[destination] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : map.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    time[next] = time[current] + 1;
                }
            }
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = time[sources[i]];
        }

        return answer;
    }
}
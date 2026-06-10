import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int[] cost : costs) {
            map.putIfAbsent(cost[0], new ArrayList<>());
            map.get(cost[0]).add(Arrays.asList(cost[1], cost[2]));
            map.putIfAbsent(cost[1], new ArrayList<>());
            map.get(cost[1]).add(Arrays.asList(cost[0], cost[2]));
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        pq.offer(Arrays.asList(0, 0));

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int node = cur.get(0);
            int cost = cur.get(1);

            if (visited[node]) continue;
            visited[node] = true;
            answer += cost;

            for (List<Integer> list : map.get(node)) {
                int nextNode = list.get(0);
                int nextCost = list.get(1);

                if (!visited[nextNode]) {
                    pq.offer(Arrays.asList(nextNode, nextCost));
                }
            }
        }

        return answer;
    }
}
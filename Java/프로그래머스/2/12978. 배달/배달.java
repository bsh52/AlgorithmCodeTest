import java.util.*;
class Solution {
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] roadInfo : road) {
            map.get(roadInfo[0]).add(Arrays.asList(roadInfo[1], roadInfo[2]));
            map.get(roadInfo[1]).add(Arrays.asList(roadInfo[0], roadInfo[2]));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] ints = pq.poll();
            int current = ints[0];
            int dist = ints[1];

            if (dist > distance[current]) continue;

            for (List<Integer> list : map.get(current)) {
                int next = list.get(0);
                int nextDist = list.get(1) + distance[current];

                if (nextDist < distance[next]) {
                    distance[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }

        for (int i : distance) {
            if (i <= K) answer++;
        }
        return answer;
    }
}
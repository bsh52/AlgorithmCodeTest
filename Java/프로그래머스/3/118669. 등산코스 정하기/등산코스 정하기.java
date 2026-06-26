import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new int[]{path[1], path[2]});
            graph[path[1]].add(new int[]{path[0], path[2]});
        }

        Arrays.sort(gates);
        Arrays.sort(summits);
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int gate : gates) isGate[gate] = true;
        for (int summit : summits) isSummit[summit] = true;

        int[] intensityList = new int[n + 1];
        Arrays.fill(intensityList, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int gate : gates) {
            pq.add(new int[]{gate, 0});
            intensityList[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int intensity = poll[1];
            if (intensity > intensityList[cur]) continue;
            if (isSummit[cur]) continue;

            for (int[] list : graph[cur]) {
                int next = list[0];
                int nextIntensity = Math.max(intensity, list[1]);
                if (isGate[next]) continue;
                if (intensityList[next] > nextIntensity) {
                    intensityList[next] = nextIntensity;
                    pq.add(new int[]{next, nextIntensity});
                }
            }
        }

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (intensityList[summit] < min) {
                min = intensityList[summit];
                answer[0] = summit;
                answer[1] = intensityList[summit];
            }
        }
        return answer;
    }
}
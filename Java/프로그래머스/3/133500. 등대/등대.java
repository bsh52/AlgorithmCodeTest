import java.util.*;
class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> map;
    int answer;
    public int solution(int n, int[][] lighthouse) {
        answer = 0;
        map = new HashMap<>();
        visited = new boolean[n + 1];
        for (int[] ints : lighthouse) {
            map.computeIfAbsent(ints[0], k -> new ArrayList<>()).add(ints[1]);
            map.computeIfAbsent(ints[1], k -> new ArrayList<>()).add(ints[0]);
        }

        dfs(1, 1);

        return answer;
    }

    private void dfs(int parent, int node) {
        for (int child : map.get(node)) {
            if (child == parent) continue;
            dfs(node, child);
            if (!visited[node] && !visited[child]) {
                visited[node] = true;
                answer++;
            }
        }
    }
}
import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited;
    int count;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            map.putIfAbsent(wire[0], new ArrayList<>());
            map.get(wire[0]).add(wire[1]);
            map.putIfAbsent(wire[1], new ArrayList<>());
            map.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            count = 0;
            visited = new boolean[n + 1];
            map.get(wire[0]).remove((Integer) wire[1]);
            map.get(wire[1]).remove((Integer) wire[0]);
            dfs(wire[1]);
            answer = Math.min(answer, Math.abs(count - (n - count)));
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        return answer;
    }

    private void dfs(int i) {
        visited[i] = true;
        count++;
        for (int j : map.get(i)) {
            if (!visited[j]) {
                dfs(j);
            }
        }
    }
}
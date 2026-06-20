import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int answer = 0;
    int[] info;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        dfs(1, 0, map.get(0));
        return answer;
    }

    private void dfs(int sheep, int wolf, List<Integer> list) {
        if (sheep <= wolf) return;
        answer = Math.max(answer, sheep);
        for (int next : list) {
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(Integer.valueOf(next));
            if (map.containsKey(next)) {
                nextList.addAll(map.get(next));
            }

            if (info[next] == 0) {
                dfs(sheep + 1, wolf, nextList);
            } else {
                dfs(sheep, wolf + 1, nextList);
            }
        }
    }
}
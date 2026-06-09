import java.util.*;
class Solution {
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    boolean[] visited;
    List<List<Integer>> comb = new ArrayList<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(Arrays.asList(edge[1], edge[2]));
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(Arrays.asList(edge[0], edge[2]));
        }
        visited = new boolean[n + 1];

        getComb(k, 0, new ArrayList<>());

        for (List<Integer> list : comb) {
            answer = Math.max(answer, bfs(infection, list));
        }

        return answer;
    }

    private int bfs(int infection, List<Integer> list) {
        List<Integer> infected = new ArrayList<>();
        infected.add(infection);
        List<Integer> newI = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int type = list.get(i);
            for (int j = 0; j < infected.size(); j++) {
                int inf = infected.get(j);
                for (int k = 0; k < map.get(inf).size(); k++) {
                    List<Integer> edge = map.get(inf).get(k);
                    if (edge.get(1) == type) {
                        if (!newI.contains(edge.get(0)) && !infected.contains(edge.get(0))) {
                            newI.add(edge.get(0));
                        }
                    }
                }
                infected.addAll(newI);
                newI.clear();
            }
        }

        return infected.size();
    }

    private void getComb(int max, int depth, List<Integer> list) {
        if (depth == max) {
            comb.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            list.add(i);
            getComb(max, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
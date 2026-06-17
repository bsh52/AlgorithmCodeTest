import java.util.*;
class Solution {
    List<List<Integer>> comb = new ArrayList<>();
    List<List<Integer>> used = new ArrayList<>();
    boolean[] visited;
    int answer = 0;
    public int solution(String[][] relation) {
        int colSize = relation[0].length;
        visited = new boolean[colSize];

        for (int i = 1; i <= colSize; i++) {
            comb.clear();
            dfs(0, i, relation, new ArrayList<>());
            checkRelation(relation);
        }

        return answer;
    }

    private void checkRelation(String[][] relation) {
        for (List<Integer> list : comb) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j : list) {
                    sb.append(relation[i][j]);
                }
                set.add(sb.toString());
            }
            if (set.size() == relation.length) {
                used.add(list);
                answer++;
            }
        }
    }

    private void dfs(int idx, int depth, String[][] relation, List<Integer> list) {
        if (isUsed(list, used)) return;

        if (list.size() == depth) {
            comb.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < relation[0].length; i++) {
            list.add(i);
            dfs(i + 1, depth, relation, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isUsed(List<Integer> list, List<List<Integer>> used) {
        for (List<Integer> u : used) {
            if (list.containsAll(u)) {
                return true;
            }
        }
        return false;
    }
}
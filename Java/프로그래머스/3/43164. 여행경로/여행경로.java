import java.util.*;
class Solution {
    boolean[] visited;
    List<List<String>> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(0, "ICN", tickets, path);

        return list.get(0).toArray(new String[0]);
    }

    private void dfs(int depth, String now, String[][] tickets, List<String> path) {
        if (depth == tickets.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(now) && !visited[i]) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(depth + 1, tickets[i][1], tickets, path);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
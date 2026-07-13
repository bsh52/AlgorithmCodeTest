import java.util.*;
class Solution {
    public long solution(int[] a, int[][] edges) {
        if (Arrays.stream(a).sum() != 0) return -1;
        if (Arrays.stream(a).allMatch(i -> i == 0)) return 0;

        long answer = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[a.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        long[] arr = Arrays.stream(a).asLongStream().toArray();

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (visited[node]) {
                long sum = 0;
                for (int child : map.get(node)) {
                    sum += arr[child];
                }
                arr[node] += sum;
                answer += Math.abs(arr[node]);
                stack.pop();
            } else {
                for (int child : map.get(node)) {
                    map.get(child).remove(node);
                    stack.push(child);
                }
                visited[node] = true;
            }
        }

        return answer;
    }
}
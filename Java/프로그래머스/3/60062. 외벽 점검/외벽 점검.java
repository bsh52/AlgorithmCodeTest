import java.util.*;
class Solution {
    int[] gap;
    int size;
    List<List<Integer>> perm = new ArrayList<>();
    public int solution(int n, int[] weak, int[] dist) {
        size = weak.length;
        gap = new int[size];
        for (int i = 0; i < size - 1; i++) {
            gap[i] = weak[i + 1] - weak[i];
        }
        gap[size - 1] = weak[0] + n - weak[size - 1];

        Arrays.sort(dist);
        boolean[] visited = new boolean[dist.length];
        for (int i = 1; i <= dist.length; i++) {
            permutation(i, 0, dist, new ArrayList<>(), visited);
        }

        for (List<Integer> list : perm) {
            for (int i = 0; i < size; i++) {
                if (isValid(i, list)) {
                    return list.size();
                }
            }
        }

        return -1;
    }

    private boolean isValid(int idx, List<Integer> dist) {
        int count = 0;
        for (int d : dist) {
            while (d - gap[idx % size] >= 0) {
                d -= gap[idx % size];
                count++;
                idx++;
            }
            count++;
            idx++;
            if (count >= size) {
                return true;
            }
        }
        return false;
    }

    private void permutation(int limit, int depth, int[] dist, List<Integer> list, boolean[] visited) {
        if (depth == limit) {
            perm.add(new ArrayList<>(list));
            return;
        }
        for (int i = dist.length - 1; i >= dist.length - limit; i--) {
            if (visited[i]) continue;
            list.add(dist[i]);
            visited[i] = true;
            permutation(limit, depth + 1, dist, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
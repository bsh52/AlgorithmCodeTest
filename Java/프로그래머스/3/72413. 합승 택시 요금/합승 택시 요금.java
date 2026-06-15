import java.util.*;
class Solution {
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    boolean[] visited;
    int size;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        size = n;
        for (int[] fare : fares) {
            map.computeIfAbsent(fare[0], k -> new ArrayList<>()).add(Arrays.asList(fare[1], fare[2]));
            map.computeIfAbsent(fare[1], k -> new ArrayList<>()).add(Arrays.asList(fare[0], fare[2]));
        }

        int[] priceFromS = getPrice(s);
        int[] priceFromA = getPrice(a);
        int[] priceFromB = getPrice(b);

        int sum1 = priceFromS[a] + priceFromS[b];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= size; i++) {
            int sum2 = priceFromS[i] + priceFromA[i] + priceFromB[i];
            min = Math.min(min, sum2);
        }

        int answer = Math.min(sum1, min);
        return answer;
    }

    private int[] getPrice(int start) {
        visited = new boolean[size + 1];
        int[] priceArr = new int[size + 1];
        Arrays.fill(priceArr, Integer.MAX_VALUE);
        priceArr[start] = 0;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        pq.add(Arrays.asList(start, 0));

        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int target = cur.get(0);
            int price = cur.get(1);
            if (visited[target]) continue;
            visited[target] = true;
            if (price > priceArr[target]) continue;

            for (List<Integer> list : map.get(target)) {
                int next = list.get(0);
                int nextPrice = price + list.get(1);
                if (visited[next]) continue;
                if (nextPrice < priceArr[next]) {
                    pq.add(Arrays.asList(next, nextPrice));
                    priceArr[next] = nextPrice;
                }
            }
        }

        return priceArr;
    }
}
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for (int weight : weights) {
            Double a = (double) weight;
            Double b = (weight * 2) / 3.0;
            Double c = weight / 2.0;
            Double d = (weight * 3) / 4.0;

            if (map.containsKey(a)) {
                answer += map.get(a);
            }
            if (map.containsKey(b)) {
                answer += map.get(b);
            }
            if (map.containsKey(c)) {
                answer += map.get(c);
            }
            if (map.containsKey(d)) {
                answer += map.get(d);
            }

            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return answer;
    }
}
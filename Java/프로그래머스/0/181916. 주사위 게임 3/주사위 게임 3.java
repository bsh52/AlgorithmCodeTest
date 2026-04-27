import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        if (map.size() == 1) {
            answer = 1111 * a;
        } else if (map.size() == 2) {
            if (map.containsValue(3)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    answer += entry.getKey() * (entry.getValue() == 3 ? 10 : 1);
                }
                answer *= answer;
            } else if (map.containsValue(2)) {
                int a1 = 0;
                int a2 = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 2 && a1 == 0) {
                        a1 = entry.getKey();
                    }
                    a2 = entry.getKey();
                }
                answer = (a1 + a2) * Math.abs(a1 - a2);
            }
        } else if (map.size() == 3) {
            int count = 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    count *= entry.getKey();
                }
            }
            answer = count;
        } else if (map.size() == 4) {
            answer = Math.min(Math.min(a, b), Math.min(c, d));
        }
        return answer;
    }
}
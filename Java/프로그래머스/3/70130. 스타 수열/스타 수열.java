import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) <= answer) {
                continue;
            }

            int count = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] != key && a[i + 1] != key) {
                    continue;
                }
                if (a[i] == a[i + 1]) {
                    continue;
                }
                count++;
                i++;
            }
            answer = Math.max(answer, count);
        }
        
        return answer * 2;
    }
}
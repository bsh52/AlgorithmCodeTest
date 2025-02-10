import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : strArr) {
            map.put(s.length(), map.getOrDefault(s.length(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > answer) {
                answer = m.getValue();
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if (!map.containsKey(key)) {
                map.put(key, i);
                answer.add(-1);
            } else {
                int index = map.get(key);
                map.put(key, i);
                answer.add(i - index);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
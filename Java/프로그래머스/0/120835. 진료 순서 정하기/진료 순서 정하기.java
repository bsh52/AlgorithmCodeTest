import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sort = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(sort);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        
        for (int i = sort.length - 1; i >= 0; i--) {
            map.put(sort[i], idx++);
        }
        
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = map.get(emergency[i]);
        }
        return answer;
    }
}
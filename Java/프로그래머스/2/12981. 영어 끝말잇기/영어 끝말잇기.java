import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        String target = words[0];
        map.put(target, 1);
        for (int i = 1; i < words.length; i++) {
            if (target.charAt(target.length() - 1) == words[i].charAt(0) && !map.containsKey(words[i])) {
                target = words[i];
            } else {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        return answer;
    }
}
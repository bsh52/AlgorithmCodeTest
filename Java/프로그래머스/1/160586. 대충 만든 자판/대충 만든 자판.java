import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> key = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (key.containsKey(c) && key.get(c) < j + 1) {
                    continue;
                }
                key.put(c, j + 1);
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (!key.containsKey(c)) {
                    sum = -1;
                    break;
                }
                sum += key.getOrDefault(c, 0);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
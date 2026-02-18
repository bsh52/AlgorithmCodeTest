import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < choices.length; i++) {
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);

            if (choices[i] == 4) {
                continue;
            } else if (choices[i] < 4) {
                map.put(type1, map.getOrDefault(type1, 0) + (4 - choices[i]));
            } else {
                map.put(type2, map.getOrDefault(type2, 0) + (choices[i] - 4));
            }
        }

        for (int i = 0; i < types.length; i += 2) {
            char type1 = types[i];
            char type2 = types[i + 1];

            int score1 = map.getOrDefault(type1, 0);
            int score2 = map.getOrDefault(type2, 0);

            if (score1 >= score2) {
                answer.append(type1);
            } else {
                answer.append(type2);
            }
        }
        
        return answer.toString();
    }
}
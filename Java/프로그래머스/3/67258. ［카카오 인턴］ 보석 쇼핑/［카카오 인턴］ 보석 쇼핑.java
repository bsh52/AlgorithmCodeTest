import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int total = set.size();
        int start = 0;
        int end = 0;
        Map<String, Integer> map = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        int answerStart = 0;
        int answerEnd = 0;

        while (true) {
            if (map.size() < total) {
                if (end == gems.length) {
                    break;
                }
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            } else {
                if (end - start < minLength) {
                    minLength = end - start;
                    answerStart = start;
                    answerEnd = end;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        answer[0] = answerStart + 1;
        answer[1] = answerEnd;

        return answer;
    }
}
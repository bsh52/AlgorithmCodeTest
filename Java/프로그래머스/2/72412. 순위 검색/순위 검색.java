import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> cache = new HashMap<>();
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String[] qArr = q.replace(" and", "").split(" ");
            String cacheKey = qArr[0] + qArr[1] + qArr[2] + qArr[3];

            List<Integer> scores;

            if (cache.containsKey(cacheKey)) {
                scores = cache.get(cacheKey);
            } else {
                scores = new ArrayList<>();
                for (String in : info) {
                    String[] iArr = in.split(" ");
                    boolean isMatch = true;
                    for (int j = 0; j < 4; j++) {
                        if (qArr[j].equals("-")) continue;
                        if (!iArr[j].equals(qArr[j])) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        scores.add(Integer.parseInt(iArr[4]));
                    }
                }
                Collections.sort(scores);
                cache.put(cacheKey, scores);
            }
            answer[i] = scores.size() - binarySearch(Integer.parseInt(qArr[4]), scores);
        }

        return answer;
    }

    int binarySearch(int score, List<Integer> scores) {
        if (scores.isEmpty() || score > scores.get(scores.size() - 1)) {
            return scores.size();
        }
        int left = 0;
        int right = scores.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
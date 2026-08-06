import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> wordMap = new HashMap<>();
        Map<Integer, List<String>> reverseWordMap = new HashMap<>();
        for (String word : words) {
            wordMap.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
            reverseWordMap.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(new StringBuilder(word).reverse().toString());
        }
        for (List<String> list : wordMap.values()) {
            Collections.sort(list);
        }
        for (List<String> list : reverseWordMap.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            List<String> list;
            String target;
            if (!query.startsWith("?")) {
                target = query;
                list = wordMap.getOrDefault(len, Collections.emptyList());
            } else {
                target = new StringBuilder(query).reverse().toString();
                list = reverseWordMap.getOrDefault(len, Collections.emptyList());
            }
            String left = target.replace("?", "a");
            String right = target.replace("?", "z");
            answer[i] = upperBound(list, right) - lowerBound(list, left);
        }
        return answer;
    }

    private int lowerBound(List<String> list, String target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int upperBound(List<String> list, String target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int parsedToday = parseToInt(today);
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 100);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] split = privacy.split(" ");
            int day = parseToInt(split[0]);
            day += termMap.getOrDefault(split[1], 0);
            if (day <= parsedToday) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int parseToInt(String today) {
        String[] split = today.split("\\.");
        return Integer.parseInt(split[0]) * 1200 + Integer.parseInt(split[1]) * 100 + Integer.parseInt(split[2]);
    }
}
import java.util.*;
class Solution {
    Map<String, Integer> courseMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (String order : orders) {
            for (int count : course) {
                checkOrder(order, count, 0, "");
            }
        }

        Map<Integer, Integer> maxMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            int len = entry.getKey().length();
            int value = entry.getValue();

            for (int i : course) {
                if (len == i) {
                    int current = maxMap.getOrDefault(i, 0);
                    if (value > current) {
                        maxMap.put(i, value);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
            for (int i : course) {
                if (entry.getKey().length() == i && entry.getValue() == maxMap.get(i)) {
                    if (maxMap.get(i) > 1) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    void checkOrder(String order, int count, int index, String current) {
        if (current.length() == count) {
            current = sorting(current);
            courseMap.put(current, courseMap.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            checkOrder(order, count, i + 1, current + order.charAt(i));
        }
    }

    String sorting(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
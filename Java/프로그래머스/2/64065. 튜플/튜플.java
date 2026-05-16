import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] split = s.split("[^0-9]");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (String str : split) {
            if (str.matches("[0-9]+")) {
                map.put(Integer.parseInt(str), map.getOrDefault(Integer.parseInt(str), 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Integer> entry : list) {
            answer.add(entry.getKey());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
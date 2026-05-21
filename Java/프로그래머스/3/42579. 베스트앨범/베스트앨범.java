import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (!genreMap.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genreMap.put(genres[i], map);
            } else {
                genreMap.get(genres[i]).put(i, plays[i]);
            }
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreList, (a, b) -> total.get(b) - total.get(a));

        for (String key : genreList) {
            Map<Integer, Integer> map = genreMap.get(key);
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
            answer.add(list.get(0));
            if (list.size() > 1) answer.add(list.get(1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
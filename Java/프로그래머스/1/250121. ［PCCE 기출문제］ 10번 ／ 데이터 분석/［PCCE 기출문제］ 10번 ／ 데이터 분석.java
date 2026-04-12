import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        int ext_idx = map.get(ext);
        int sort_idx = map.get(sort_by);

        for (int[] d : data) {
            if (d[ext_idx] < val_ext) {
                answer.add(d);
            }
        }

        answer.sort((a, b) -> a[sort_idx] - b[sort_idx]);

        return answer.toArray(new int[0][]);
    }
}
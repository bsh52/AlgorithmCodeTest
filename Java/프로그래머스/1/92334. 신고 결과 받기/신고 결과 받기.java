import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> uniqueReport = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> reported = new HashMap<>();
        Map<String, Integer> userIdx = new HashMap<>();

        for (String s : uniqueReport) {
            String[] split = s.split(" ");
            reported.put(split[1], reported.getOrDefault(split[1], 0) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            userIdx.put(id_list[i], i);
        }

        for (String s : uniqueReport) {
            String[] split = s.split(" ");
            String id = split[0];
            String reportId = split[1];
            if (reported.get(reportId) >= k) {
                answer[userIdx.get(id)]++;
            }
        }

        return answer;
    }
}
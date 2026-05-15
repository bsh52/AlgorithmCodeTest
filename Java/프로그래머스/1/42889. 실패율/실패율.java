import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new LinkedHashMap<>();
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            int roundTotal = 0;
            for (int stage : stages) {
                if (stage <= i && stage > i - 1) {
                    roundTotal++;
                }
            }
            double fail = 0;
            if (total != 0) {
                fail = (double) roundTotal / total;
            }
            total -= roundTotal;
            map.put(i, fail);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
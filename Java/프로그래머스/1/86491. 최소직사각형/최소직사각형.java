import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> minArr = new ArrayList<>();
        List<Integer> maxArr = new ArrayList<>();
        for (int[] size : sizes) {
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            minArr.add(min);
            maxArr.add(max);
        }
        int maxOfMin = minArr.stream().mapToInt(Integer::intValue).max().orElse(0);
        int maxOfMax = maxArr.stream().mapToInt(Integer::intValue).max().orElse(0);

        int answer = maxOfMin * maxOfMax;
        return answer;
    }
}
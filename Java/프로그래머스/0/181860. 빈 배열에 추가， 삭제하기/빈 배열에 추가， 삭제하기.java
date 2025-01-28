import java.util.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i] * (flag[i] ? 2 : 1); j++) {
                if (flag[i]) {
                    answer.add(arr[i]);
                } else {
                    answer.remove(answer.size() - 1);
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
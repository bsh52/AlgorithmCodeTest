import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                answerList.add(i);
            }
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
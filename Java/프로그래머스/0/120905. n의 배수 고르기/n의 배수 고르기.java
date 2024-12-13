import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                answerList.add(numlist[i]);
            }
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
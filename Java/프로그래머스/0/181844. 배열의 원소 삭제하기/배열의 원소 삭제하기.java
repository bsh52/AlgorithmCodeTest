import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answerList = new ArrayList<>();
        for (int i : arr) {
            answerList.add(i);
        }
        
        for (int i : delete_list) {
            answerList.remove(Integer.valueOf(i));
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
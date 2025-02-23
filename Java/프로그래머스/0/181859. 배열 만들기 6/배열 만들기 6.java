import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> answer = new Stack<>();
        
        for (int i : arr) {
            if (!answer.isEmpty() && answer.peek() == i) {
                answer.pop();
            } else {
                answer.push(i);
            }
        }
        
        return answer.isEmpty() ? new int[] {-1} : answer.stream().mapToInt(i -> i).toArray();
    }
}
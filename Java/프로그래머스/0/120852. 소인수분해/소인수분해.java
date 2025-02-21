import java.util.*;

class Solution {
    public int[] solution(int n) {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        int i = 2;
        
        while (n >= i && n != 0) {
            if (n % i == 0) {
                answer.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
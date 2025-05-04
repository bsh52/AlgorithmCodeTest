import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    int sum = numbers[i] + numbers[j];
                    if (!answer.contains(sum)) {
                        answer.add(sum);
                    }
                }
            }
        }
        answer.sort(Integer::compareTo);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
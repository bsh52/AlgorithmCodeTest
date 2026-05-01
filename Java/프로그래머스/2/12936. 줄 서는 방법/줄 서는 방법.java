import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long total = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }
        k--;

        for (int i = 0; i < n; i++) {
            total /= n - i;
            answer[i] = list.remove((int) (k / total));
            k %= total;
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Deque<int[]> dStack = new ArrayDeque<>();
        Deque<int[]> pStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                dStack.push(new int[]{i + 1, deliveries[i]});
            }

            if (pickups[i] != 0) {
                pStack.push(new int[]{i + 1, pickups[i]});
            }
        }

        while (!dStack.isEmpty() || !pStack.isEmpty()) {
            int d = calc(dStack, cap);
            int p = calc(pStack, cap);

            answer += Math.max(d, p) * 2L;
        }

        return answer;
    }

    private int calc(Deque<int[]> stack, int cap) {
        int result = 0;
        int max = 0;

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int index = pop[0];
            int value = pop[1];

            if (index > max) {
                max = index;
            }

            if (value + result > cap) {
                value = value + result - cap;
                stack.push(new int[]{index, value});
                return max;
            }

            result += value;
        }

        return max;
    }
}
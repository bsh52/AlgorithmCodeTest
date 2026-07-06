import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisor = getDivisor(number);
        for (int i = 0; i < divisor.length; i++) {
            if (divisor[i] > limit) divisor[i] = power;
        }
        return Arrays.stream(divisor).sum();
    }

    private int[] getDivisor(int number) {
        int[] divisor = new int[number];
        for (int i = 1; i <= number; i++) {
            int div = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) div++;
                else if (i % j == 0) div += 2;
            }
            divisor[i - 1] = div;
        }
        return divisor;
    }
}
class Solution {
    public int solution(int[][] signals) {
        int max = 1;
        for (int[] signal : signals) {
            int sum = signal[0] + signal[1] + signal[2];
            max = lcm(max, sum);
        }

        for (int i = 1; i <= max; i++) {
            boolean isYellow = true;
            for (int[] signal : signals) {
                int sum = signal[0] + signal[1] + signal[2];
                int target = (i - signal[0]) % sum;
                if (target > 0 && target <= signal[1]) {
                    continue;
                }
                isYellow = false;
            }
            if (isYellow) {
                return i;
            }
        }
        return -1;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
class Solution {
    public int solution(int n) {
        if (n%2 == 1) return 0;

        long[] dp = new long[n + 1];
        long sum = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i-2] * 3 + sum * 2 + 2) % 1_000_000_007;
            sum += dp[i-2];
        }
        
        return (int) dp[n];
    }
}
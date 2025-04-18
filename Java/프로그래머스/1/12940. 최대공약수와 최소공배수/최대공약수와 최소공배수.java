class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        // 최대공약수
        int gcd = 0;
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }
        
        // 최소공배수
        int lcm = 0;
        for (int i = 1; i <= n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                lcm = i;
                break;
            }
        }
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
}
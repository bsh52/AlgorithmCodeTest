class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] arr = number.split("0");

        for (String s : arr) {
            if (s.length() == 0) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }
    
    boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
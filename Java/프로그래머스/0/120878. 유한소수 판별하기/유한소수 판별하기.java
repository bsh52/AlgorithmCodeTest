class Solution {
    public int solution(int a, int b) {
        int answer = 2;

        b /= gcd(a, b);

        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;

        answer = b == 1 ? 1 : 2;

        return answer;
    }

    int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
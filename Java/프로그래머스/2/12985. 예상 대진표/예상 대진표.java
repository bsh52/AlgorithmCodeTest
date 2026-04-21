class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        while (n != 1) {
            a = next(a);
            b = next(b);
            if (a == b) {
                break;
            }
            n /= 2;
            answer++;
        }

        return answer;
    }

    int next(int n) {
        return n / 2 + n % 2;
    }
}
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisors = new int[e + 1];

        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                divisors[i * j]++;
            }
        }

        int max = 0, idx = 0;
        for (int i = e; i >= 0; i--) {
            max = max > divisors[i] ? max : divisors[i];
            idx = max > divisors[i] ? idx : i;
            divisors[i] = idx;
        }

        for (int i = 0; i < starts.length; i++) {
            answer[i] = divisors[starts[i]];
        }

        return answer;
    }
}
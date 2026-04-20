class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while (n > 0) {
            int mod = n % 3;
            n /= 3;

            if (mod == 0) {
                n--;
            }

            answer = numbers[mod] + answer;
        }

        return answer;
    }
}
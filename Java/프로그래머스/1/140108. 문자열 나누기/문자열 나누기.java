class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 1;
        int otherCount = 0;

        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (c == ' ') {
                c = s.charAt(i);
                continue;
            }

            if (s.charAt(i) == c) {
                xCount++;
            } else {
                otherCount++;
            }

            if (xCount == otherCount) {
                answer++;
                otherCount = 0;
                xCount = 1;
                c = ' ';
            }
        }

        if (c != ' ') {
            answer++;
        }

        return answer;
    }
}
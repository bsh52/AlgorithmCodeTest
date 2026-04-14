class Solution {
    boolean solution(String s) {
        boolean answer = true;

        if (s.startsWith(")") || s.endsWith("(") || s.length() % 2 != 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        answer = count == 0;

        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(j, j + i - 1, s)) {
                    return i;
                }
            }
        }
        return answer;
    }

    boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
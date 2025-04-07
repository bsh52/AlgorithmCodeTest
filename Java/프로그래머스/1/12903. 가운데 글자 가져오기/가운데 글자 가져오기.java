class Solution {
    public String solution(String s) {
        String answer = "";
        int center = s.length() % 2 == 0 ? (int) (s.length() / 2 - 1) : (int) Math.floor(s.length() / 2);
        if (s.length() % 2 == 0) {
            answer = s.substring(center, center + 2);
        } else {
            answer = s.substring(center, center + 1);
        }
        return answer;
    }
}
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] strBits = my_string.split("");
        for (String s : strBits) {
            if (s == s.toLowerCase()) {
                answer += s.toUpperCase();
            } else {
                answer += s.toLowerCase();
            }
        }
        return answer;
    }
}
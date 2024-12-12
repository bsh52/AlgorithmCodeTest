class Solution {
    public int solution(String my_string) {
        String[] numArr = my_string.toLowerCase().replaceAll("[a-z]","").split("");
        int answer = 0;
        for (String s : numArr) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}
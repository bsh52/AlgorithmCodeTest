import java.util.Arrays;
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        answer = Arrays.stream(strlist).mapToInt(String::length).toArray();
        return answer;
    }
}
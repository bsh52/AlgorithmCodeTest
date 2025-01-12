import java.util.stream.*;
class Solution {
    public String solution(int age) {
        String answer = String.valueOf(age).chars().mapToObj(c -> String.valueOf((char) (49 + c))).collect(Collectors.joining());
        return answer;
    }
}
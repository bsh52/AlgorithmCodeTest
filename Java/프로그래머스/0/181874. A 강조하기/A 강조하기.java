import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String myString) {
        String[] arr = myString.split("");
        String lower = Arrays.stream(arr).map(String::toLowerCase).collect(Collectors.joining("")).toString();
        String answer = lower.replace("a", "A");
        return answer;
    }
}
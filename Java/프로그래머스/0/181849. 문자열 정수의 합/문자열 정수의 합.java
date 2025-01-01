import java.util.*;
class Solution {
    public int solution(String num_str) {
        String[] arr = num_str.split("");
        int answer = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).sum();
        return answer;
    }
}
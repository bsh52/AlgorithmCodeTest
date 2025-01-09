import java.util.*;
class Solution {
    public String solution(String[] seoul) {
        int i = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + i + "에 있다";
    }
}
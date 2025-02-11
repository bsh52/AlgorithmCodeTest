import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        List<String> answer = new ArrayList<>();
        myStr = myStr.replaceAll("[a|b|c]", " ");
        String[] arr = myStr.split(" ");
        
        for (String s : arr) {
            if (!s.equals("")) {
                answer.add(s);
            }
        }
        
        if (answer.isEmpty()) {
            answer.add("EMPTY");
        }
        
        return answer.toArray(String[]::new);
    }
}
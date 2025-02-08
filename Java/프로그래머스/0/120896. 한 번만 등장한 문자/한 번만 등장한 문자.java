import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        
        Arrays.stream(arr).filter(str -> s.indexOf(str) == s.lastIndexOf(str))
            .sorted().forEach(list::add);
        
        return String.join("", list);
    }
}
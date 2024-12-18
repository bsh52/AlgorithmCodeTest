import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i * 5 < names.length; i++) {
            strList.add(names[i * 5]);
        };
        String[] answer = strList.toArray(new String[strList.size()]);
        return answer;
    }
}
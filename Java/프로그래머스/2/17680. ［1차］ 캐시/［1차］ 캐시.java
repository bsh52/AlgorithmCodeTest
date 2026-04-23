import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for (String city : cities) {
            String lowerCaseCity = city.toLowerCase();
            if (!list.contains(lowerCaseCity)) {
                answer += 5;
                list.add(lowerCaseCity);
                if (list.size() > cacheSize) {
                    list.remove(0);
                }
            } else {
                answer += 1;
                list.remove(lowerCaseCity);
                list.add(lowerCaseCity);
            }
        }
        return answer;
    }
}
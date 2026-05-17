import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            String id = split[1];
            String name = "";
            if (!action.equals("Leave")) {
                name = split[2];
                map.put(id, name);
            }
        }

        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            String id = split[1];
            if (action.equals("Enter")) {
                answer.add(map.get(id) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                answer.add(map.get(id) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
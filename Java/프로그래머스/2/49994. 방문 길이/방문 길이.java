import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int endX = startX;
            int endY = startY;
            String s = "";

            switch (dirs.charAt(i)) {
                case 'U':
                    endY++;
                    s += "" + startX + startY + endX + endY;
                    break;
                case 'D':
                    endY--;
                    s += "" + endX + endY + startX + startY;
                    break;
                case 'L':
                    endX--;
                    s += "" + endX + endY + startX + startY;
                    break;
                case 'R':
                    endX++;
                    s += "" + startX + startY + endX + endY;
                    break;
            }

            if (endX > 5 || endX < -5 || endY > 5 || endY < -5) {
                continue;
            }
            set.add(s);
            startX = endX;
            startY = endY;
        }

        answer = set.size();

        return answer;
    }
}
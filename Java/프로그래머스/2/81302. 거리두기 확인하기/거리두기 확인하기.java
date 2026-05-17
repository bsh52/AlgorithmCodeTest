import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    int check(String[] place) {
        List<int[]> pSet = new ArrayList<>();

        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    pSet.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < pSet.size() - 1; i++) {
            for (int j = i + 1; j < pSet.size(); j++) {
                int range = Math.abs(pSet.get(i)[0] - pSet.get(j)[0]) + Math.abs(pSet.get(i)[1] - pSet.get(j)[1]);
                if (range == 2) {
                    if (betweenP(pSet.get(i), pSet.get(j), place)) {
                        continue;
                    }
                    return 0;
                } else if (range == 1) {
                    return 0;
                }
            }
        }

        return 1;
    }

    boolean betweenP(int[] p1, int[] p2, String[] place) {
        int row1 = Math.min(p1[0], p2[0]);
        int col1 = Math.min(p1[1], p2[1]);
        int row2 = Math.max(p1[0], p2[0]);
        int col2 = Math.max(p1[1], p2[1]);
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (place[i].charAt(j) != 'X' && place[i].charAt(j) != 'P') {
                    return false;
                }
            }
        }
        return true;
    }
}
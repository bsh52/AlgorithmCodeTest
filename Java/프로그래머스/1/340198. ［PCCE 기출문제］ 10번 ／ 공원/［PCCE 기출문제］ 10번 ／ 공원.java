class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                for (int mat : mats) {
                    if (isPossible(park, i, j, mat)) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    boolean isPossible(String[][] park, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x + i >= park.length || y + j >= park[0].length) {
                    return false;
                }
                if (!park[x + i][y + j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
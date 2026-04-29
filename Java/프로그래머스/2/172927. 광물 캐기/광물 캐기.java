import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = Math.min(picks[0] + picks[1] + picks[2], minerals.length / 5 + 1);
        int[][] arr = new int[count][3];
        int dp = 0, ip = 0, sp = 0;

        for (int i = 0; i < minerals.length; i += 5) {
            if (i / 5 == count) {
                break;
            }

            for (int j = i; j < i + 5; j++) {
                String s = minerals[j];
                if (s.equals("diamond")) {
                    dp++;
                    ip += 5;
                    sp += 25;
                } else if (s.equals("iron")) {
                    dp++;
                    ip++;
                    sp += 5;
                } else if (s.equals("stone")) {
                    dp++;
                    ip++;
                    sp++;
                }
                if (j == minerals.length - 1) {
                    break;
                }
            }

            arr[i / 5][0] = dp;
            arr[i / 5][1] = ip;
            arr[i / 5][2] = sp;

            dp = ip = sp = 0;
        }
        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);

        for (int i = 0; i < count; i++) {
            if (picks[0] != 0) {
                answer += arr[i][0];
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += arr[i][1];
                picks[1]--;
            } else {
                answer += arr[i][2];
                picks[2]--;
            }
        }

        return answer;
    }
}
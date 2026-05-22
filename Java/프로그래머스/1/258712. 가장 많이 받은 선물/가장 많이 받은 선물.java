import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] presentArr = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int friendIndex = Arrays.asList(friends).indexOf(split[0]);
            int friendIndex2 = Arrays.asList(friends).indexOf(split[1]);
            presentArr[friendIndex][friendIndex2]++;
        }

        int[][] sumArr = new int[friends.length][3];

        for (int i = 0; i < presentArr.length; i++) {
            for (int j = 0; j < presentArr[i].length; j++) {
                sumArr[i][0] += presentArr[i][j];
                sumArr[i][1] += presentArr[j][i];
            }
            sumArr[i][2] = sumArr[i][0] - sumArr[i][1];
        }

        int[] giftCount = new int[friends.length];

        for (int i = 0; i < presentArr.length; i++) {
            for (int j = 0; j < presentArr[i].length; j++) {
                if (i == j) continue;
                if (presentArr[i][j] > presentArr[j][i]) {
                    giftCount[i]++;
                } else if (presentArr[i][j] == presentArr[j][i]) {
                    if (sumArr[i][2] > sumArr[j][2]) {
                        giftCount[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < giftCount.length; i++) {
            answer = Math.max(answer, giftCount[i]);
        }

        return answer;
    }
}
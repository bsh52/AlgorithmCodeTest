import java.util.*;
class Solution {
    int[] ryan = new int[11];
    int max = 0;
    List<int[]> comb = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        int[] answer = {};

        int aScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0) {
                aScore += (10 - i);
            }
        }
        max = -aScore;
        dfs(0, n, info, max);

        if (max <= 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < info.length; i++) {
                if (comb.size() == 1) break;

                int maxPoint = 0;
                for (int[] ryan : comb) {
                    maxPoint = Math.max(ryan[10 - i], maxPoint);
                }

                int c = 0;
                while (c < comb.size()) {
                    if (comb.get(c)[10 - i] != maxPoint) {
                        comb.remove(c);
                    } else {
                        c++;
                    }
                }
            }
            answer = comb.get(0);
        }

        return answer;
    }

    private void dfs(int idx, int n, int[] info, int now) {
        if (n == 0) {
            if (now > max) {
                max = now;
                comb = new ArrayList<>();
                comb.add(ryan.clone());
            } else if (now == max) {
                comb.add(ryan.clone());
            }
        } else if (idx < 11 && n > 0) {
            for (int i = 0; i <= info[idx] + 1; i++) {
                ryan[idx] = i;
                if (ryan[idx] > info[idx]) {
                    if (info[idx] == 0) {
                        now += (10 - idx);
                    } else if (info[idx] > 0) {
                        now += (10 - idx) * 2;
                    }
                }
                dfs(idx + 1, n - i, info, now);
                ryan[idx] = 0;
            }
        }
    }
}
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] route = new int[m][n][2];
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) {
                break;
            }
            route[0][i][1] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) {
                break;
            }
            route[i][0][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    continue;
                }
                if (i > 0 && j > 0) {
                    int left = route[i][j - 1][1] % MOD;
                    if (cityMap[i][j - 1] == 0) {
                        left = (left + route[i][j - 1][0]) % MOD;
                    }

                    int up = route[i - 1][j][0] % MOD;
                    if (cityMap[i - 1][j] == 0) {
                        up = (up + route[i - 1][j][1]) % MOD;
                    }

                    route[i][j][1] = left % MOD;
                    route[i][j][0] = up % MOD;
                }
            }
        }

        return (route[m - 1][n - 1][0] + route[m - 1][n - 1][1]) % MOD;
    }
}
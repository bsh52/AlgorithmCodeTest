class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[] nums = new int[n];
        String[] ops = new String[n-1];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[2 * i]);

            if (i < n - 1) {
                ops[i] = arr[2 * i + 1];
            }
        }

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int leftMax = maxDp[i][k];
                    int leftMin = minDp[i][k];
                    int rightMax = maxDp[k + 1][j];
                    int rightMin = minDp[k + 1][j];

                    int maxVal;
                    int minVal;

                    if (ops[k].equals("+")) {
                        maxVal = leftMax + rightMax;
                        minVal = leftMin + rightMin;
                    } else {
                        maxVal = leftMax - rightMin;
                        minVal = leftMin - rightMax;
                    }

                    maxDp[i][j] = Math.max(maxDp[i][j], maxVal);
                    minDp[i][j] = Math.min(minDp[i][j], minVal);
                }
            }
        }

        return maxDp[0][n - 1];
    }
}
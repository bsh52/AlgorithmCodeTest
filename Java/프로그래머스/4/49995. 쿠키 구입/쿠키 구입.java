class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;

        for (int i = 0; i < n - 1; i++) {
            int left = i;
            int right = i + 1;

            int leftSum = cookie[left];
            int rightSum = cookie[right];

            while (true) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }

                if (leftSum <= rightSum) {
                    left--;
                    if (left < 0) {
                        break;
                    }
                    leftSum += cookie[left];
                } else {
                    right++;
                    if (right >= n) {
                        break;
                    }
                    rightSum += cookie[right];
                }
            }
        }

        return answer;
    }
}
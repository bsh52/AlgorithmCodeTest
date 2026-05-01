class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0, max = 200000000;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] < mid) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= k) {
                    break;
                }
            }

            if (count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
}
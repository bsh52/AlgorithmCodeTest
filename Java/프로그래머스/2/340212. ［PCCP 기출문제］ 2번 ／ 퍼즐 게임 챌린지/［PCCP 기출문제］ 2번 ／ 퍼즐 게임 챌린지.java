class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int left = 1;
        int right = 0;
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            long totalTime = 0;
            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                int time_cur = times[i];
                int time_prev = i == 0 ? 0 : times[i - 1];

                long difficult = diff - mid;
                if (diff - mid < 0) difficult = 0;
                totalTime += difficult * (time_cur + time_prev) + time_cur;
            }

            if (totalTime > limit) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        answer = left;

        return answer;
    }
}
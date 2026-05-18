class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;

        int min = 1;
        int max = 0;
        for (int diff : diffs) {
            max = Math.max(max, diff);
        }

        while (min < max) {
            int level = (min + max) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                int diff = diffs[i];
                int time = times[i];
                int time_prev = 0;
                if (i - 1 >= 0) {
                    time_prev = times[i - 1];
                }
                if (diff <= level) {
                    total += time;
                } else {
                    total += (long) (diff - level) * (time + time_prev) + time;
                }
            }

            if (total > limit) {
                min = level + 1;
            } else {
                max = level;
            }
        }

        answer = min;
        return answer;
    }
}
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        int left = 0, right = 100000;
        int time = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = cores.length;
            for (int core : cores) {
                count += mid / core;
            }

            if (count >= n) {
                right = mid - 1;
                time = mid;
            } else {
                left = mid + 1;
            }
        }

        int prev = cores.length;
        for (int core : cores) {
            prev += (time - 1) / core;
        }
        int remain = n - prev;

        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                remain--;
                if (remain == 0) {
                    answer = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
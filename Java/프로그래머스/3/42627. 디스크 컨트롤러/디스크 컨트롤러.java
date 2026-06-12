import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> waitPq = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        Arrays.sort(jobs, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        PriorityQueue<int[]> jobPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        jobPq.addAll(Arrays.asList(jobs));

        int sum = 0;
        int end = 0;
        while (true) {
            if (waitPq.isEmpty()) {
                int[] poll = jobPq.poll();
                end = poll[0];
                waitPq.add(poll);
            } else {
                while (!waitPq.isEmpty()) {
                    int[] cur = waitPq.poll();
                    end += cur[1];
                    sum += end - cur[0];

                    int size = jobPq.size();
                    for (int i = 0; i < size; i++) {
                        int[] next = jobPq.peek();
                        if (next != null && next[0] <= end) {
                            waitPq.add(jobPq.poll());
                        }
                    }
                }
            }

            if (jobPq.isEmpty() && waitPq.isEmpty()) {
                break;
            }
        }
        answer = sum / jobs.length;

        return answer;
    }
}
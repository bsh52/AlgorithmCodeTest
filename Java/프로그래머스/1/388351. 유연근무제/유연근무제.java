class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) {
            int count = 0;
            int limit = schedules[i];
            for (int j = 0; j < timelogs[0].length; j++) {
                if (startday % 7 != 6 && startday % 7 != 0) {
                    if (timelogs[i][j] <= calcTime(limit)) {
                        count++;
                    }
                }
                startday++;
            }
            if (count == 5) {
                answer++;
            }
        }
        return answer;
    }

    int calcTime(int time) {
        time += 10;
        if (time % 100 >= 60) {
            time += 40;
        }
        return time;
    }
}
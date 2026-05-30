class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int max = timeToInt(video_len);
        int min = 0;
        int now = timeToInt(pos);
        int start = timeToInt(op_start);
        int end = timeToInt(op_end);


        now = skipOp(now, start, end);
        for (String command : commands) {
            if (command.equals("next")) {
                now += 10;
                if (now > max) {
                    now = max;
                }
            } else {
                now -= 10;
                if (now < min) {
                    now = min;
                }
            }
            now = skipOp(now, start, end);
        }
        answer = timeToString(now);

        return answer;
    }

    int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    String timeToString(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }

    int skipOp(int now, int start, int end) {
        if (now >= start && now <= end) {
            return end;
        }
        return now;
    }
}
import java.util.*;
class Solution {
    public int solution(String[] lines) {
        int answer = 0;

        List<Log> logs = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            logs.add(getLog(split[1], split[2]));
        }

        for (int i = 0; i < logs.size(); i++) {
            long base = logs.get(i).end;
            int count = 0;
            for (int j = 0; j < logs.size(); j++) {
                if (isCycle(base, logs.get(j).start, logs.get(j).end)) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private boolean isCycle(long baseStart, long start, long end) {
        long baseEnd = baseStart + 999;
        return baseStart <= end && baseEnd >= start;
    }

    private Log getLog(String time, String duration) {
        long end = toMillis(time);
        long start = end - getDuration(duration) + 1;
        return new Log(start, end);
    }

    private long getDuration(String duration) {
        String d = duration.replace("s", "");
        if (!d.contains(".")) {
            return Long.parseLong(d) * 1000;
        }
        String[] split = d.split("\\.");
        return Long.parseLong(split[0]) * 1000 + Long.parseLong((split[1] + "000").substring(0, 3));
    }

    private long toMillis(String time) {
        String[] split = time.split("\\.");
        String[] hms = split[0].split(":");
        long hour = Long.parseLong(hms[0]) * 3600;
        long minute = Long.parseLong(hms[1]) * 60;
        long second = Long.parseLong(hms[2]);
        long millis = Long.parseLong(split[1]);
        return (hour + minute + second) * 1000 + millis;
    }

    class Log {
        long start;
        long end;

        public Log(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
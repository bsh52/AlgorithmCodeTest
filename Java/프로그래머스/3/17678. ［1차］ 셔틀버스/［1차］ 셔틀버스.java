import java.util.*;
class Solution {
    List<Integer> timeList = new ArrayList<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String first = "09:00";
        int startTime = timeToInt(first);
        int lastTime = timeToInt(first) + (n - 1) * t;
        for (String s : timetable) {
            if (timeToInt(s) > lastTime) continue;
            timeList.add(timeToInt(s));
        }
        Collections.sort(timeList);

        if (timeList.size() < m) {
            answer = timeToString(lastTime);
        } else {
            answer = getTime(startTime, lastTime, n, t, m);
        }

        return answer;
    }

    private String getTime(int startTime, int lastTime, int count, int gap, int max) {
        int now = startTime;
        while (count > 0) {
            int cnt = 0;
            for (int i = 0; i < timeList.size(); i++) {
                if (timeList.get(i) <= now) {
                    cnt++;
                }
            }
            if (cnt >= max) {
                if (now == lastTime) {
                    return timeToString(timeList.get(max - 1) - 1);
                }
                timeList = timeList.subList(max, timeList.size());
            } else {
                timeList = timeList.subList(cnt, timeList.size());
            }
            now += gap;
            count--;
         }
         return timeToString(lastTime);
    }

    int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    String timeToString(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}
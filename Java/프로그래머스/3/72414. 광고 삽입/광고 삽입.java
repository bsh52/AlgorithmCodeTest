class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSecond = toSecond(play_time);
        int advSecond = toSecond(adv_time);
        long[] arr = new long[playSecond + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = toSecond(split[0]);
            int end = toSecond(split[1]);

            arr[start] += 1;
            arr[end] -= 1;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        int idx = 0;
        long max = arr[advSecond - 1];
        for (int i = 1; i < arr.length - advSecond; i++) {
            long cur = arr[advSecond + i - 1] - arr[i - 1];
            if (cur > max) {
                max = cur;
                idx = i;
            }
        }

        return toTime(idx);
    }

    private int toSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

    private String toTime(int second) {
        int hour = second / 3600;
        second %= 3600;
        int minute = second / 60;
        second %= 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
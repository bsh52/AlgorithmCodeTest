import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<int[]> set = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] a = line[i];
                int[] b = line[j];
                long denominator = ((long) a[0] * (long) b[1] - (long) a[1] * (long) b[0]);
                if (denominator == 0) continue;
                long numeratorX = ((long) a[1] * (long) b[2] - (long) a[2] * (long) b[1]);
                long numeratorY = ((long) a[2] * (long) b[0] - (long) a[0] * (long) b[2]);
                if (numeratorX % denominator != 0 || numeratorY % denominator != 0) continue;
                long x = numeratorX / denominator;
                long y = numeratorY / denominator;
                minX = Math.min(minX, (int) x);
                minY = Math.min(minY, (int) y);
                maxX = Math.max(maxX, (int) x);
                maxY = Math.max(maxY, (int) y);
                int[] arr = {(int) x, (int) y};
                set.add(arr);
            }
        }

        int xLength = maxX - minX + 1;
        int yLength = maxY - minY + 1;
        answer = new String[yLength];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ".".repeat(xLength);
        }

        List<int[]> setList = new ArrayList<>(set);

        for (int[] ints : setList) {
            int x = ints[0] - minX;
            int y = ints[1] - minY;
            answer[yLength - y - 1] = answer[yLength - y - 1].substring(0, x) + "*" + answer[yLength - y - 1].substring(x + 1);
        }

        return answer;
    }
}
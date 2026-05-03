import java.util.*;
class Solution {
    List<int[]> points = new ArrayList<>();
    List<Double> area = new ArrayList<>();

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        getPoints(k);
        getSizes(points);

        double sum = 0;
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = points.size() + ranges[i][1] - 1;
            if (start > end) {
                answer[i] = -1.0;
                continue;
            }
            for (int j = start; j < end; j++) {
                sum += area.get(j);
            }
            answer[i] = sum;
            sum = 0;
        }

        return answer;
    }

    void getPoints(int k) {
        int index = 0;
        points.add(new int[]{index++, k});
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            points.add(new int[]{index++, k});
        }
    }

    void getSizes(List<int[]> points) {
        int[] start = points.get(0);
        int startY = start[1];
        for (int i = 1; i < points.size(); i++) {
            int[] target = points.get(i);
            int targetY = target[1];

            int minY = Math.min(startY, targetY);
            int difY = Math.abs(startY - targetY);

            double size = minY + (double) difY / 2;

            area.add(size);

            start = target;
            startY = targetY;
        }
    }
}
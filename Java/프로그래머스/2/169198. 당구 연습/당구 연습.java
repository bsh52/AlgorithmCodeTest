class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            int result = Integer.MAX_VALUE;

            if (!(startY == targetY && startX <= targetX)) {
                result = Math.min(result, distance(startX, startY, m + (m - targetX), targetY));
            }
            if (!(startY == targetY && startX >= targetX)) {
                result = Math.min(result, distance(startX, startY, -targetX, targetY));
            }
            if (!(startX == targetX && startY <= targetY)) {
                result = Math.min(result, distance(startX, startY, targetX, n + (n - targetY)));
            }
            if (!(startX == targetX && startY >= targetY)) {
                result = Math.min(result, distance(startX, startY, targetX, -targetY));
            }

            answer[i] = result;
        }

        return answer;
    }

    int distance(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
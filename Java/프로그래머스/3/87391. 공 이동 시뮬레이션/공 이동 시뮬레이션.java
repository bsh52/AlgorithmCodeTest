class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;
        long minX = x, maxX = x, minY = y, maxY = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int num = queries[i][1];

            switch (dir) {
                case 0:
                    minY = minY == 0 ? 0 : minY + num;
                    maxY = Math.min(maxY + num, m - 1);
                    break;
                case 1:
                    minY = Math.max(minY - num, 0);
                    maxY = maxY == m - 1 ? m - 1 : maxY - num;
                    break;
                case 2:
                    minX = minX == 0 ? 0 : minX + num;
                    maxX = Math.min(maxX + num, n - 1);
                    break;
                case 3:
                    minX = Math.max(minX - num, 0);
                    maxX = maxX == n - 1 ? n - 1 : maxX - num;
                    break;
            }
            if (minX > maxX || minY > maxY) {
                return 0;
            }
        }

        answer = (maxX - minX + 1) * (maxY - minY + 1);

        return answer;
    }
}
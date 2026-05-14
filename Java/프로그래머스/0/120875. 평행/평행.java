class Solution {
    public int solution(int[][] dots) {
        int answer = 0;

        int a = getSlope(dots[0], dots[1], dots[2], dots[3]);
        int b = getSlope(dots[0], dots[2], dots[1], dots[3]);
        int c = getSlope(dots[0], dots[3], dots[2], dots[1]);

        if (a == 1 || b == 1 || c == 1) {
            answer = 1;
        }
        
        return answer;
    }

    int getSlope(int[] a, int[] b, int[] c, int[] d) {
        return (a[0] - b[0]) * (c[1] - d[1]) == (a[1] - b[1]) * (c[0] - d[0]) ? 1 : 0;
    }
}
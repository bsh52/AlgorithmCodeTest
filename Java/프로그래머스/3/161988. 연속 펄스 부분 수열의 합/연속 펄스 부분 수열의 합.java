class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean isPositive = true;
        long sum1 = 0;
        long sum2 = 0;

        for (int i : sequence) {
            sum1 += isPositive ? i : -i;
            sum2 += isPositive ? -i : i;

            sum1 = Math.max(sum1, 0);
            sum2 = Math.max(sum2, 0);

            answer = Math.max(answer, Math.max(sum1, sum2));
            isPositive = !isPositive;
        }
        return answer;
    }
}
class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = count;
        return answer;
    }

    void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }
}
import java.util.*;
class Solution {
    int answer;
    int[] nums;
    public int solution(int[] nums) {
        this.nums = nums;
        answer = 0;
        dfs(0, 0, 0);
        return answer;
    }

    private void dfs(int depth, int idx, int sum) {
        if (depth == 3) {
            if (isPrime(sum)) answer++;
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
            dfs(depth + 1, i + 1, sum);
            sum -= nums[i];
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1 || num % 2 == 0) return false;
        if (num == 2) return true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                arr[i] += arr[i - m] % 1000000007;
            }
        }
        answer = arr[n];

        return answer;
    }
}
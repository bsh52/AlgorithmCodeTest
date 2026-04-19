class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = 0;
        int pre = sequence.length;

        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            while (right < sequence.length && sum > k) {
                sum -= sequence[left];
                left++;
            }
            if (sum == k && right - left < pre) {
                pre = right - left;
                answer[0] = left;
                answer[1] = right;
            }
        }

        return answer;
    }
}
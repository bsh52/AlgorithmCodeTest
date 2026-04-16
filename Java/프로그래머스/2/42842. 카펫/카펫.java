class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for (int i = 3; i < sum; i++) {
            int min = i;
            int max = sum / min;
            
            if ((max - 2) * (min - 2) == yellow) {
                answer[0] = max;
                answer[1] = min;
                break;
            }
        }
        return answer;
    }
}
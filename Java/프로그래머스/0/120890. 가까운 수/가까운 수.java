class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int gap = Math.abs(n - array[0]);
        
        for (int i : array) {
            if (gap > Math.abs(n - i)) {
                gap = Math.abs(n - i);
                answer = i;
            } else if (gap == Math.abs(n - i) && answer > i) {
                answer = i;
            }
        }
        
        return answer;
    }
}
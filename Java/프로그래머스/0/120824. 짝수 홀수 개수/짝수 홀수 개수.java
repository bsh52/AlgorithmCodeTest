class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0) {
                evenSum++;
            } else {
                oddSum++;
            }
        }
        answer = new int[]{evenSum, oddSum};
        return answer;
    }
}
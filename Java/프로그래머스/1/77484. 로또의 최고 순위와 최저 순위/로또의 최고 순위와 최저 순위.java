class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCount = 0;
        int matchCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else {
                for (int winNum : win_nums) {
                    if (lotto == winNum) {
                        matchCount++;
                        break;
                    }
                }
            }
        }

        int maxRank = Math.min(7 - (matchCount + zeroCount), 6);
        int minRank = Math.min(7 - matchCount, 6);
        
        answer = new int[]{maxRank, minRank};
        return answer;
    }
}
class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] < 0) {
            answer = dot[1] < 0 ? 3 : 2;
        } else {
            answer = dot[1] > 0 ? 1 : 4;
        }
        return answer;
    }
}
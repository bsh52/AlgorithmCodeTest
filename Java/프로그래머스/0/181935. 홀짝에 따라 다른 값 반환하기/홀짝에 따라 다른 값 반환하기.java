class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = n; i >= 0; i -= 2) {
            answer += i % 2 == 0 ? Math.pow(i,2) : i;
        }
        
        return answer;
    }
}
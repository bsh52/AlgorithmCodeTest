class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int count = 1;
        
        if (a == b || b == c || c == a) {
            count++;
        }
        if (a == b && b == c) {
            count++;
        }
        for (int i = 1; i <= count; i++) {
            answer *= (Math.pow(a,i) + Math.pow(b,i) + Math.pow(c,i));
        }
        
        return answer;
    }
}
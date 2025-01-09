class Solution {
    public long solution(long n) {
        double d = Math.sqrt(n);
        long answer = Math.floor(d) == d ? (long) Math.pow(d+1, 2) : -1;
        return answer;
    }
}
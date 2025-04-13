class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        for (int i = 1; i <= count; i++) {
            total += price * i;
        }
        answer = total - money;
        return answer > 0 ? answer : 0;
    }
}
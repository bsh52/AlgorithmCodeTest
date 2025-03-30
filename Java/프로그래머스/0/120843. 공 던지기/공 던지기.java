class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int leng = numbers.length;
        int i = (k - 1) * 2;
        i %= leng;
        answer = numbers[i];
        return answer;
    }
}
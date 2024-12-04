class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int lamb = lambAmount(n);
        int drink = drinkAmount(k);
        int disc = discount(n);
        answer = lamb + drink - disc;
        return answer;
    }
    
    private int lambAmount(int num) {
        return num * 12000;
    }
    
    private int drinkAmount(int num) {
        return num * 2000;
    }
    
    private int discount(int num) {
        return (num / 10) * 2000;
    }
}
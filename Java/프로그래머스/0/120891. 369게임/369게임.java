class Solution {
    public int solution(int order) {
        String[] arr = String.valueOf(order).split("");
        int answer = 0;
        
        for (String s : arr) {
            if (s.equals("3") || s.equals("6") || s.equals("9")) {
                answer++;
            }
        }
        
        return answer;
    }
}
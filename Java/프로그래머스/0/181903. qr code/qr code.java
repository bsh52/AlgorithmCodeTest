class Solution {
    public String solution(int q, int r, String code) {
        String[] arr = code.split("");
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i % q == r) {
                answer.append(arr[i]);
            }
        }
        return answer.toString();
    }
}
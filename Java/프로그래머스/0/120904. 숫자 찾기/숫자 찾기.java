class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String[] arr = String.valueOf(num).split("");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(String.valueOf(k))) {
                answer = i + 1;
                break;
            }
            answer = -1;
        }
        return answer;
    }
}
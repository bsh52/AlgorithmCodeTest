class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        String a = A;
        
        for (int i = 0; i < A.length(); i++) {
            if (a.equals(B)) {
                answer = i;
                return answer;
            }

            a = a.charAt(A.length() - 1) + a.substring(0, A.length() - 1);
        }

        return answer;
    }
}
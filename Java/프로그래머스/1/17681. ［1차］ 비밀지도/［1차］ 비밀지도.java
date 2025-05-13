class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((arr1[i] & (1 << (n - j - 1))) != 0 || (arr2[i] & (1 << (n - j - 1))) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}
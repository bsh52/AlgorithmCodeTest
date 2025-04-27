class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pVal = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String sub = t.substring(i, i + p.length());
            long subVal = Long.parseLong(sub);
            if (subVal <= pVal) {
                answer++;
            }
        }
        return answer;
    }
}
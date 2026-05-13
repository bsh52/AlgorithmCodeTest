class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int sum = 0;
        int x = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                x += s.equals("x") ? 1 : Integer.parseInt(s.replace("x", ""));
            } else if (!s.equals("+")) {
                sum += Integer.parseInt(s);
            }
        }

        answer = (x == 0 ? "" : x == 1 ? "x" : x + "x") + (sum == 0 ? (x == 0 ? "0" : "") : x == 0 ? sum : " + " + sum);

        return answer;
    }
}
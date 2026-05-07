class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        String target = "110";

        for (int i = 0; i < s.length; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for (char c : s[i].toCharArray()) {
                sb.append(c);
                int leng = sb.length();
                if (leng >= 3 && sb.charAt(leng - 3) == '1' && sb.charAt(leng - 2) == '1' && sb.charAt(leng - 1) == '0') {
                    sb.setLength(leng - 3);
                    count++;
                }
            }

            int idx = sb.lastIndexOf("0");
            sb.insert(idx + 1, target.repeat(count));
            answer[i] = sb.toString();
        }

        return answer;
    }
}
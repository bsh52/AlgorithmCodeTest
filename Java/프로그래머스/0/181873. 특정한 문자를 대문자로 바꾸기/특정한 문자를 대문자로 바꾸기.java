class Solution {
    public String solution(String my_string, String alp) {
        StringBuffer sb = new StringBuffer();
        String[] strArr = my_string.split("");
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(alp)) {
                sb.append(strArr[i].toUpperCase());
            } else {
                sb.append(strArr[i]);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
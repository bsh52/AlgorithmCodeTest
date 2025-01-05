class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuffer sb = new StringBuffer();
        String[] arr = my_string.split("");
        String temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
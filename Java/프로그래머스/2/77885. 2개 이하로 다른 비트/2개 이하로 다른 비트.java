class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String s = Long.toBinaryString(numbers[i]);

            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int idx = s.lastIndexOf("0");

                if (idx == -1) {
                    String tmp = "10" + s.substring(1);
                    answer[i] = Long.parseLong(tmp, 2);
                } else {
                    String tmp = s.substring(0, idx) + "10" + s.substring(idx+2);
                    answer[i] = Long.parseLong(tmp, 2);
                }
            }
        }

        return answer;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L" ;
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                right = number;
            } else {
                if (number == 0) number = 11;
                
                int leftDistance = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int rightDistance = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;

                if (leftDistance < rightDistance) {
                    answer += "L";
                    left = number;
                } else if (leftDistance > rightDistance) {
                    answer += "R";
                    right = number;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = number;
                    } else {
                        answer += "L";
                        left = number;
                    }
                }
            }
        }
        return answer;
    }
}
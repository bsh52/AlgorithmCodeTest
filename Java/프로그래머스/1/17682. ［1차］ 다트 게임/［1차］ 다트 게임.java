class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] point = dartResult.split("");
        int[] score = new int[3];

        int index = -1;
        for (int i = 0; i < point.length; i++) {
            if (point[i].matches("[0-9]")) {
                index++;
                score[index] = Integer.parseInt(point[i]);
                if (point[i+1].matches("[0-9]")) {
                    score[index] *= 10;
                    i++;
                }
            }

            switch (point[i]) {
                case "S":
                    score[index] = (int) Math.pow(score[index], 1);
                    break;
                case "D":
                    score[index] = (int) Math.pow(score[index], 2);
                    break;
                case "T":
                    score[index] = (int) Math.pow(score[index], 3);
                    break;
                case "*":
                    score[index] *= 2;
                    if (index >= 1) score[index-1] *= 2;
                    break;
                case "#":
                    score[index] *= -1;
            }
        }

        for (int i : score) {
            answer += i;
        }

        return answer;
    }
}
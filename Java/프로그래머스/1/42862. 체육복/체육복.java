import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++; // 잃어버린 학생이 여벌 체육복을 가지고 있는 경우
                    lost[i] = -1; // 이미 빌린 학생은 -1로 표시
                    reserve[j] = -1; // 이미 빌려준 학생은 -1로 표시
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    answer++;
                    reserve[j] = -1; // 이미 빌려준 학생은 -1로 표시
                    break;
                }
            }
        }

        return answer;
    }
}
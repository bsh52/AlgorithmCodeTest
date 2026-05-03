import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            int count = 0;
            int next = i;
            while (cards[next] != -1) {
                int temp = cards[next] - 1;
                cards[next] = -1;
                next = temp;
                count++;
            }
            list.add(count);
        }

        list.sort(Comparator.reverseOrder());
        answer = list.get(0) * list.get(1);
        return answer;
    }
}
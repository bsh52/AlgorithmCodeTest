import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String oper : operations) {
            String[] split = oper.split(" ");
            if (split[0].equals("I")) {
                minQ.offer(Integer.parseInt(split[1]));
                maxQ.offer(Integer.parseInt(split[1]));
            } else {
                if (Integer.parseInt(split[1]) == 1) {
                    Integer maxN = maxQ.poll();
                    if (maxN != null) {
                        minQ.remove(maxN);
                    }
                } else {
                    Integer minN = minQ.poll();
                    if (minN != null) {
                        maxQ.remove(minN);
                    }
                }
            }
        }

        answer[0] = maxQ.peek() == null ? 0 : maxQ.poll();
        answer[1] = minQ.peek() == null ? 0 : minQ.poll();

        return answer;
    }
}
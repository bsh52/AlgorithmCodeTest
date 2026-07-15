import java.util.*;
class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> center = new ArrayDeque<>();
        for (int i = 0; i < rc.length; i++) {
            left.add(rc[i][0]);
            right.add(rc[i][rc[i].length - 1]);
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 1; j < rc[i].length - 1; j++) {
                deque.add(rc[i][j]);
            }
            center.add(deque);
        }


        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                center.peekFirst().addFirst(left.pollFirst());
                right.addFirst(center.peekFirst().pollLast());
                center.peekLast().addLast(right.pollLast());
                left.addLast(center.peekLast().pollFirst());

            } else if (operation.equals("ShiftRow")) {
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
                center.addFirst(center.pollLast());
            }
        }

        int[][] answer = new int[rc.length][rc[0].length];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = left.pollFirst();
            answer[i][answer[i].length - 1] = right.pollFirst();
            Deque<Integer> centerTemp = center.pollFirst();
            for (int j = 1; j < answer[i].length - 1; j++) {
                answer[i][j] = centerTemp.pollFirst();
            }
        }
        return answer;
    }
}
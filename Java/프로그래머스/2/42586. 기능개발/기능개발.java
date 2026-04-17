import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
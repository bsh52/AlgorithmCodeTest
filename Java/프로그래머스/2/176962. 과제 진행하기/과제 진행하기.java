import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<Subject> stack = new ArrayDeque<>();
        PriorityQueue<Subject> subjects = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (int i = 0; i < plans.length; i++) {
            Subject subject = new Subject(plans[i][0], convertTime(plans[i][1]), Integer.parseInt(plans[i][2]));
            subjects.add(subject);
        }

        Subject now = subjects.poll();
        int time = now.start;

        while (!subjects.isEmpty()) {
            time += now.left;
            Subject next = subjects.peek();

            if (time > next.start) {
                now.left = time - next.start;
                stack.push(now);
            } else {
                answer.add(now.name);
                if (!stack.isEmpty()) {
                    now = stack.pop();
                    continue;
                }
            }
            now = subjects.poll();
            time = now.start;
        }

        answer.add(now.name);
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    class Subject {
        String name;
        int start;
        int left;

        Subject(String name,int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }

    int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int step = Integer.parseInt(parts[1]);

            int X = answer[0];
            int Y = answer[1];

            switch (direction) {
                case "E":
                    Y += step;
                    break;
                case "W":
                    Y -= step;
                    break;
                case "S":
                    X += step;
                    break;
                case "N":
                    X -= step;
                    break;
            }

            if (X >= 0 && X < park.length && Y >= 0 && Y < park[0].length()) {
                boolean canMove = true;
                for (int i = Math.min(answer[0], X); i <= Math.max(answer[0], X); i++) {
                    for (int j = Math.min(answer[1], Y); j <= Math.max(answer[1], Y); j++) {
                        if (park[i].charAt(j) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if (!canMove) break;
                }
                if (canMove) {
                    answer[0] = X;
                    answer[1] = Y;
                }
            }
        }

        return answer;
    }
}
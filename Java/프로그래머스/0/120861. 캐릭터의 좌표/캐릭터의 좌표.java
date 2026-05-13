class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;
        for (String s : keyinput) {
            if (s.equals("left")) {
                x = Math.max(-maxX, x - 1);
            } else if (s.equals("right")) {
                x = Math.min(maxX, x + 1);
            } else if (s.equals("up")) {
                y = Math.min(maxY, y + 1);
            } else if (s.equals("down")) {
                y = Math.max(-maxY, y - 1);
            }
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
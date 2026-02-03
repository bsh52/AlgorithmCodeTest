class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                int minimum = Integer.MAX_VALUE;

                for (String key : keymap) {
                    int index = key.indexOf(ch);
                    if (index != -1) {
                        minimum = Math.min(minimum, index + 1);
                    }
                }

                if (minimum == Integer.MAX_VALUE) {
                    count = -1;
                    break;
                } else {
                    count += minimum;
                }
            }

            answer[i] = count;
        }
        return answer;
    }
}
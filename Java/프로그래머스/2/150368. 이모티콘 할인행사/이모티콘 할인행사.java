class Solution {
    int[][] discount;
    int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        discount = new int[4][emoticons.length];
        discountEmoticons(emoticons);
        int[] selected = new int[emoticons.length];
        dfs(0, selected, users, emoticons);
        return answer;
    }

    void dfs(int depth, int[] selected, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int subscriber = 0;
            int totalPrice = 0;

            for (int[] user : users) {
                int userDiscount = user[0];
                int limit = user[1];
                int sum = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    int discountRate = (selected[i] + 1) * 10;
                    if (discountRate >= userDiscount) {
                        sum += discount[selected[i]][i];
                    }
                }
                if (sum >= limit) {
                    subscriber++;
                } else {
                    totalPrice += sum;
                }
            }

            if (subscriber > answer[0]) {
                answer[0] = subscriber;
                answer[1] = totalPrice;
            } else if (subscriber == answer[0]) {
                answer[1] = Math.max(answer[1], totalPrice);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            selected[depth] = i;
            dfs(depth + 1, selected, users, emoticons);
        }
    }

    void discountEmoticons(int[] emoticons) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                discount[i][j] = emoticons[j] * (10 - (i + 1)) / 10;
            }
        }
    }
}
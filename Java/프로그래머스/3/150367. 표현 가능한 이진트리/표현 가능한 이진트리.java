class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int len = 0;
            while (len < binary.length()) {
                len = len * 2 + 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len - binary.length(); j++) {
                sb.append("0");
            }
            sb.append(binary);

            char[] tree = sb.toString().toCharArray();
            answer[i] = dfs(tree, 0, len - 1, '1') ? 1 : 0;
        }

        return answer;
    }

    private boolean dfs(char[] tree, int left, int right, char parent) {
        if (left > right) return true;

        int mid = (left + right) / 2;
        char cur = tree[mid];

        if (parent == '0' && cur == '1') return false;

        return dfs(tree, left, mid - 1, cur) && dfs(tree, mid + 1, right, cur);
    }
}
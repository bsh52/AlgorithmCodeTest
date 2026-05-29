class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int first = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < first) {
                first = a[i];
            }
            left[i] = first;
        }
        int last = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < last) {
                last = a[i];
            }
            right[i] = last;
        }

        for (int i = 0; i < a.length; i++) {
            if (!(left[i] < a[i] && right[i] < a[i])) {
                answer++;
            }
        }
        return answer;
    }
}
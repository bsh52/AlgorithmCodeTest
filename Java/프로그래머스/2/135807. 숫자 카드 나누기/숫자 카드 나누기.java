class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (!isDivisible(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        if (!isDivisible(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        return answer;
    }

    int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    boolean isDivisible(int[] arr, int n) {
        for (int i : arr) {
            if (i % n == 0) {
                return true;
            }
        }
        return false;
    }
}
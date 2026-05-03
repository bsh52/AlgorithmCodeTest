class Solution {
    public int[] solution(long begin, long end) {
        int[] result = new int[(int) (end - begin + 1)];
        int index = 0;
        for (long i = begin; i <= end; i++, index++) {
            result[index] = getMaxDivisor((int) i);
        }

        return result;
    }

    private int getMaxDivisor(int number) {
        if (number <= 1) {
            return 0;
        }

        int result = 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i <= 10000000) {
                    return number / i;
                }

                if (i <= 10000000) {
                    result = Math.max(result, i);
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
class Solution {
    fun solution(arr: IntArray): IntArray {
        if (arr.size == 1) return intArrayOf(-1)
        var answer = IntArray(arr.size - 1)

        var min = Integer.MAX_VALUE
        for (v in arr) {
            if (v < min) min = v
        }

        var idx = 0;
        for (v in arr) {
            if (v != min) answer[idx++] = v
        }
        return answer
    }
}
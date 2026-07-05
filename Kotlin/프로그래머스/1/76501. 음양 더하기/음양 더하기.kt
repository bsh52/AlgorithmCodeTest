class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0

        for ((i, e) in absolutes.withIndex()) {
            if (signs[i]) {
                answer += e
            } else {
                answer -= e
            }
        }

        return answer
    }
}
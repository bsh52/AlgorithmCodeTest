import kotlin.math.*
class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxA = 0
        var maxB = 0

        for (l in sizes) {
            l.sort()
            maxA = max(maxA, l[0])
            maxB = max(maxB, l[1])
        }

        return maxA * maxB
    }
}
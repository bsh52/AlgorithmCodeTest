import kotlin.math.*
class Solution {
    fun solution(n: Long): Long {
        val nSqrt = sqrt(n.toDouble())
        if (floor(nSqrt) == nSqrt) return (nSqrt+1).pow(2).toLong()
        return -1
    }
}
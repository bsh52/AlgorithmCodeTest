import java.util.*;
class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = IntArray(score.size)
        val pq = PriorityQueue<Int> { a, b -> a - b }
        for ((i, e) in score.withIndex()) {
            pq.add(e)
            if (pq.size > k) {
                pq.poll()
            }
            answer[i] = pq.peek()
        }
        return answer
    }
}
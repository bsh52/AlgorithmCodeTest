class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = IntArray(s.length)
        val map = mutableMapOf<Char, Int>()
        for ((i, element) in s.withIndex()) {
            val idx = map.getOrDefault(element, -1)
            answer[i] = if (idx == -1) -1 else i - idx
            map[element] = i
        }
        return answer
    }
}
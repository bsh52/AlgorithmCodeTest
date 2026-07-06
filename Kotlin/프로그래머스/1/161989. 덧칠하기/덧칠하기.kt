class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        val stack = ArrayDeque<Int>()
        section.sort()
        stack.add(section[0])

        for (e in section) {
            if (stack.last() + m <= e) stack.add(e)
        }

        return stack.size
    }
}
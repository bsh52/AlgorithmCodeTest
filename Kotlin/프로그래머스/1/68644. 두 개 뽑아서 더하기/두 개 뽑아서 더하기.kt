class Solution {
    val answer = mutableListOf<Int>()
    fun solution(numbers: IntArray): IntArray {
        dfs(0, 0, 0, numbers)
        answer.sort()
        return answer.toIntArray()
    }

    private fun dfs(idx: Int, depth: Int, sum: Int, numbers: IntArray) {
        if (depth == 2) {
            if (answer.contains(sum)) return
            answer.add(sum)
            return
        }

        for (i in idx until numbers.size) {
            dfs(i + 1, depth + 1, sum + numbers[i], numbers)
        }
    }
}
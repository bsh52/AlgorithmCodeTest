class Solution {
    var answer: Int = 0
    fun solution(number: IntArray): Int {
        dfs(0,0, 0, number)
        return answer
    }

    private fun dfs(idx: Int, depth: Int, sum: Int, number: IntArray) {
        if (depth == 3) {
            if (sum == 0) {
                answer++
            }
        }
        for (i in idx until number.size) {
            dfs(i + 1, depth + 1, sum + number[i], number)
        }
    }
}
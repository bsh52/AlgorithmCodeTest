class Solution {
    fun solution(s: String): String {
        var answer = ""
        var idx = 0
        if (s.length % 2 == 0) {
            idx = s.length / 2 - 1
            answer = s.substring(idx, idx + 2)
        } else {
            idx = s.length / 2
            answer = s.substring(idx, idx + 1)
        }
        return answer
    }
}
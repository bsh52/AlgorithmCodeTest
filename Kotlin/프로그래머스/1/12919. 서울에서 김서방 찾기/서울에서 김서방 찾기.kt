class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = ""
        for ((i, e) in seoul.withIndex()) {
            if (e == "Kim") answer = "김서방은 ${i}에 있다"
        }
        return answer
    }
}
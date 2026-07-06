class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var num = n
        while (num >= a) {
            val exchange = num / a * b
            answer += exchange
            num = exchange + num % a
        }
        return answer
    }
}
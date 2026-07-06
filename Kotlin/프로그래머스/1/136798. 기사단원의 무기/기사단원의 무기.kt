import kotlin.math.sqrt
class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for (i in 1..number) {
            var count = 0
            for (j in 1..sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    count += 2
                }
                if (j * j == i) {
                    count -= 1
                }
            }
            answer += if (count > limit) power else count
        }

        return answer
    }
}
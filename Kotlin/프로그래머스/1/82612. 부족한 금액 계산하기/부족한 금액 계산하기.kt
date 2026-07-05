class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var total: Long = 0
        for (i in 1..count) {
            total += price * i
        }
        return if (total - money > 0) total - money else 0
    }
}
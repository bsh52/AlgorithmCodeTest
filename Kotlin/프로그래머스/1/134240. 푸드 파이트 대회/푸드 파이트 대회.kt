class Solution {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        for (i in 1 until food.size) {
            sb.append(i.toString().repeat(food[i] / 2))
        }
        val reverse = StringBuilder().append(sb).reverse()
        return sb.append("0").append(reverse).toString()
    }
}
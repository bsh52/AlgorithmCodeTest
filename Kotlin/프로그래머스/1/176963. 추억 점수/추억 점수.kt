class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer = IntArray((photo.size))
        val map = HashMap<String, Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }

        for (i in photo.indices) {
            var sum = 0
            for (str in photo[i]) {
                sum += map.getOrDefault(str, 0)
            }
            answer[i] = sum
        }
        return answer
    }
}
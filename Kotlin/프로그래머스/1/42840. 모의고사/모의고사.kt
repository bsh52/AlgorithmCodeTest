class Solution {
    fun solution(answers: IntArray): IntArray {
        val person = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        val score = IntArray(person.size)

        for ((i, answer) in answers.withIndex()) {
            for ((index, element) in person.withIndex()) {
                if (answer == element[i % element.size]) score[index]++;
            }
        }

        val max = score.max()
        val answer = mutableListOf<Int>()
        for (i in score.indices) {
            if (score[i] == max) answer.add(i + 1)
        }

        return answer.toIntArray()
    }
}
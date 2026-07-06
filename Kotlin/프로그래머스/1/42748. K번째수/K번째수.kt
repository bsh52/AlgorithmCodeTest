class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
                (s, e, k) ->
            array.copyOfRange(s - 1, e).sorted()[k - 1]
        }.toIntArray()
    }
}
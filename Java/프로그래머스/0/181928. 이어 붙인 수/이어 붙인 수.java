class Solution {
    public int solution(int[] num_list) {
        int even = 0;
        int odd = 0;
        
        for (int i : num_list) {
            if (i % 2 == 0) {
                even *= 10;
                even += i;
            } else {
                odd *= 10;
                odd += i;
            }
        }
        
        return even + odd;
    }
}
class Solution {
    public int[] solution(int[] arr, int n) {
        int idx = arr.length % 2 == 0 ? 1 : 0;
        
        for (int i = idx; i < arr.length; i+=2) {
            arr[i] = arr[i] + n;
        }
        
        return arr;
    }
}
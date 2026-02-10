class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = wallpaper[0].length();
        int minY = wallpaper.length;
        int maxX = 0;
        int maxY = 0;
        
        for (int y = 0; y < wallpaper.length; y++) {
            for (int x = 0; x < wallpaper[y].length(); x++) {
                if (wallpaper[y].charAt(x) == '#') {
                    if (x < minX) minX = x;
                    if (y < minY) minY = y;
                    if (x + 1 > maxX) maxX = x + 1;
                    if (y + 1 > maxY) maxY = y + 1;
                }
            }
        }
        
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY;
        answer[3] = maxX;
        return answer;
    }
}
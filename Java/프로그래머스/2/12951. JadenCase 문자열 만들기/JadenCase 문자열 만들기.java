class Solution {
    public String solution(String s) {
        String[] split = s.toLowerCase().split(" ", -1);
        for (int i = 0; i < split.length; i++) {
            if (split[i].isEmpty()) continue;
            split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
        }

        return String.join(" ", split);
    }
}
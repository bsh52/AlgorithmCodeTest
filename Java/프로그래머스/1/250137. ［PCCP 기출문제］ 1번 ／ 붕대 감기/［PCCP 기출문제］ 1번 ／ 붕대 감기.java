class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 0;

        for (int i = 0; i < attacks.length; i++) {
            if (i != 0) {
                int totalTime = attacks[i][0] - time - 1;
                health += totalTime * bandage[1] + (totalTime / bandage[0]) * bandage[2];
                health = Math.min(health, maxHealth);
            }
            health -= attacks[i][1];
            if (health <= 0) {
                return -1;
            }
            time = attacks[i][0];
        }

        return health;
    }
}
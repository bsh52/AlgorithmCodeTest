class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = bandage[0];
        int heal = bandage[1];
        int addHeal = bandage[2];
        int maxHealth = health;
        int maxTime = attacks[attacks.length - 1][0];

        int idx = 1;
        for (int i = 1; i <= maxTime; i++) {
            int attackTime = 0;
            int damage = 0;
            for (int[] attack : attacks) {
                if (i == attack[0]) {
                    attackTime = attack[0];
                    damage = attack[1];
                }
            }
            if (i == attackTime) {
                health -= damage;
                idx = 1;
                if (health <= 0) {
                    return -1;
                }
                continue;
            }

            if (idx % time == 0) {
                health += (heal + addHeal);
            } else {
                health += heal;
            }

            if (health > maxHealth) {
                health = maxHealth;
            }
            idx++;
        }
        answer = health;

        return answer;
    }
}
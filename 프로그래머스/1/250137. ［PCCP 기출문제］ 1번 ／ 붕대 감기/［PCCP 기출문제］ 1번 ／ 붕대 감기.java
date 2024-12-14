class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int lastAttackTime = 0;
        
        for (int[] attack : attacks) {
            // 공격 시간 직전까지만 힐을 진행
            int healTime = attack[0] - lastAttackTime - 1;
            int heal = healTime * bandage[1];
            int additionalHeal = bandage[2] * (int) Math.floor(healTime / bandage[0]);
            
            // 체력 회복
            health += heal + additionalHeal;
            if (maxHealth < health) health = maxHealth;
            
            // 공격 개시
            health -= attack[1];
            if (health <= 0) return -1;
            
            // 마지막 공격 시간 업데이트
            lastAttackTime = attack[0];
        }
        
        return health;
    }
}
package GameSpringFramework.charater;

public interface Character {

    String getCharacterName();
    void setCharacterName(String characterName);
    int getHealth();
    void setHealth(int health);
    int getAttackPower();
    void setAttackPower(int attackPower);
    double getCriticalStrikeChance();
    void setCriticalStrikeChance(double criticalStrikeChance);
    double getDefense();
    void setDefense(double defense);
    String getEquippedWeapon();
    void setEquippedWeapon(String equippedWeapon);
    void dialogue();
}

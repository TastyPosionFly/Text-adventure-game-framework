package GameSpringFramework.charater;

public class hero implements Character {
    private String characterName;
    private int health;
    private int attackPower;
    private double criticalStrikeChance;
    private double defense;
    private String equippedWeapon;

    @Override
    public String getCharacterName() {
        return characterName;
    }

    @Override
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public double getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    @Override
    public void setCriticalStrikeChance(double criticalStrikeChance) {
        this.criticalStrikeChance = criticalStrikeChance;
    }

    @Override
    public double getDefense() {
        return defense;
    }

    @Override
    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public String getEquippedWeapon() {
        return equippedWeapon;
    }

    @Override
    public void setEquippedWeapon(String equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    @Override
    public void dialogue() {
        System.out.println(characterName + ": I am ready for battle!");
    }
}

package GameSpringFramework.item;

import GameSpringFramework.charater.Character;

public class Weapons implements Item {
    private final Character traget;
    private final Character initiator;
    private final int weaponAttack;

    public Weapons(Character traget, Character initiator, int weaponAttack) {
        this.traget = traget;
        this.initiator = initiator;
        this.weaponAttack = weaponAttack;
    }


    @Override
    public void use() {
        int damage = (int) ((initiator.getAttackPower() + weaponAttack) * initiator.getCriticalStrikeChance() - traget.getDefense());
        System.out.println(initiator.getCharacterName() + " 对 " + traget.getCharacterName() + " 通过 " + initiator.getEquippedWeapon() + " 造成了 " + damage + "伤害");
        int newHealth = traget.getHealth() - damage;
        traget.setHealth(newHealth);
        System.out.println(traget.getCharacterName() + "还剩下" + traget.getHealth() + "血");
    }
}

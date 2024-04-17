package GameSpringFramework.action;

import GameSpringFramework.charater.Character;
import GameSpringFramework.item.Item;
import GameSpringFramework.item.Weapons;
import GameSpringFramework.reader.ItemXMLReader;

import java.util.Map;

public class AttackAction implements Action {
    private Map<String, Map<String, Integer>> itemMap;

    public AttackAction() {
        itemMap = ItemXMLReader.getItemMap();
    }

    @Override
    public void execute(Character attacker, Character defender) {
        String equippedWeapon = attacker.getEquippedWeapon();
        int weaponAttack = itemMap.get("weapons").get(equippedWeapon);
        Item weapons = new Weapons(defender, attacker, weaponAttack);
        weapons.use();
    }
}

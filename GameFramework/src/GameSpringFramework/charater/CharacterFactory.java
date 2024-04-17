package GameSpringFramework.charater;

import GameSpringFramework.reader.ItemXMLReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterFactory {
    private static final Random random = new Random();

    public static Character createHero(String name, Class<? extends Character> characterClass) {
        int health = random.nextInt(1,10);
        int attackPower = random.nextInt(5);
        double criticalStrikeChance = random.nextDouble(1,1.5);
        double defense = random.nextInt(2);
        String equippedWeapon = "手";

        Character character = null;
        try {
            character = characterClass.newInstance();
            character.setCharacterName(name);
            character.setHealth(health);
            character.setAttackPower(attackPower);
            character.setCriticalStrikeChance(criticalStrikeChance);
            character.setDefense(defense);
            character.setEquippedWeapon(equippedWeapon);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return character;
    }

    public static Character createMonster(String name, Class<? extends Character> characterClass) {
        int health = random.nextInt(1,10);
        int attackPower = random.nextInt(5);
        double criticalStrikeChance = random.nextDouble(1,1.5);
        double defense = random.nextInt(2);
        List<String> weaponsName = new ArrayList<>(ItemXMLReader.getItemMap().get("weapons").keySet());
        String equippedWeapon = weaponsName.get(random.nextInt(weaponsName.size()));

        Character character = null;
        try {
            character = characterClass.newInstance();
            character.setCharacterName(name);
            character.setHealth(health);
            character.setAttackPower(attackPower);
            character.setCriticalStrikeChance(criticalStrikeChance);
            character.setDefense(defense);
            character.setEquippedWeapon(equippedWeapon);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        character.dialogue();

        return character;
    }

}

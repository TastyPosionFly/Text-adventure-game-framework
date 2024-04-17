package GameSpringFramework;

import GameSpringFramework.charater.CharacterFactory;
import GameSpringFramework.charater.Character;
import GameSpringFramework.reader.AOPReader;
import GameSpringFramework.reader.ActionReader;
import GameSpringFramework.reader.ItemXMLReader;


public class Main {
    public static void main(String[] args) {
        ActionReader.loadConfig();
        AOPReader.AOPXMLReader();
        ItemXMLReader.loadItemXML();
        AspectProgram aspectProgram = new AspectProgram();

        Character hero = CharacterFactory.createHero("主角", GameSpringFramework.charater.hero.class);
        System.out.println("你进入了一个神秘的世界。。。");
        System.out.println("你捡到了一个宝物");
        System.out.println("你使用宝物");
        System.out.println("一把长剑，你感觉自己力量大大增强了");

        hero.setEquippedWeapon("长剑");

        EncounterSystem encounterSystem = new EncounterSystem(aspectProgram, hero);

        try {
            encounterSystem.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

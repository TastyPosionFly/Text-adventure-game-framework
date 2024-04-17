package GameSpringFramework;

import GameSpringFramework.charater.Character;
import GameSpringFramework.reader.AOPReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class EncounterSystem {
    private List<String> beforeMethod;
    private List<String> afterMethod;
    private AspectProgram aspectProgram;
    private BattleSystem battleSystem;
    private Character hero;

    public EncounterSystem(AspectProgram aspectProgram, Character hero) {
        this.aspectProgram = aspectProgram;
        battleSystem = new BattleSystem(hero);
        this.hero = hero;
        beforeMethod = AOPReader.getBeforeMethod();
        afterMethod = AOPReader.getAfterMethod();
    }

    public void startGame() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        while (hero.getHealth() > 0) {
            for (String methodName : beforeMethod) {
                Method beforeMethodMethod = AspectProgram.class.getMethod(methodName);
                beforeMethodMethod.invoke(aspectProgram);
            }

            battleSystem.fight();

            for (String methodName : afterMethod) {
                Method afterMethodMethod = AspectProgram.class.getMethod(methodName);
                afterMethodMethod.invoke(aspectProgram);
            }
        }

    }
}

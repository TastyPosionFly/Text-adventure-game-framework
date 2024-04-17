package GameSpringFramework;

import GameSpringFramework.action.Action;
import GameSpringFramework.charater.Character;
import GameSpringFramework.charater.CharacterFactory;
import GameSpringFramework.reader.ActionReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    private Character hero;
    private List<String> actionList;
    private Random random;


    public BattleSystem(Character hero) {
        this.hero = hero;
        this.actionList = new ArrayList<>(ActionReader.getActionMap().keySet());
        this.random = new Random();
    }

    public void fight() {
        Character monster = CharacterFactory.createMonster("哥布林", GameSpringFramework.charater.monster.class);
        while (hero.getHealth() > 0 && monster.getHealth() > 0) {

            System.out.println("输入你的动作");
            Scanner scanner = new Scanner(System.in);
            String heroActionType = scanner.nextLine();

            Action heroAction = ActionReader.getAction(heroActionType);
            if (heroAction == null) {
                System.out.println("未知动作");
                continue;
            }

            Action heroProxy = (Action) Proxy.newProxyInstance(
                    Action.class.getClassLoader(),
                    new Class[]{Action.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return method.invoke(heroAction, hero, monster);
                        }
                    });

            heroProxy.execute(hero, monster);

            String monsterActionType = actionList.get(random.nextInt(actionList.size()));
            Action monsterAction = ActionReader.getAction(monsterActionType);

            Action monsterProxy = (Action) Proxy.newProxyInstance(
                    Action.class.getClassLoader(),
                    new Class[]{Action.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return method.invoke(monsterAction, monster, hero);
                        }
                    });

            monsterProxy.execute(monster, hero);
        }
        if (monster.getHealth() <= 0) {
            System.out.println(monster.getCharacterName()+"倒下了");
        }
    }
}

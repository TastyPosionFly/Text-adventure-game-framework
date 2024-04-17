package GameSpringFramework.action;

import GameSpringFramework.charater.Character;

public interface Action {
    void execute(Character attacker, Character defender);
}

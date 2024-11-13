package Encounter.Enemy;

import Encounter.Enemies;

public class Fire extends Enemies {
    public static String displayText = "당신은 불을 때러 왔다.";
    public static int numOfOptions = 2;
    public static String[] options = new String[] {"불을 땐다", "참지 못 하고 무장신선을 무력으로 제압하러 간다"};

    public Fire() {
        super("불", 20,
                10, 1, 1, 0, false);

    }
}

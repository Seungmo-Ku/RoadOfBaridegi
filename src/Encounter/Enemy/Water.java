package Encounter.Enemy;

import Encounter.Enemies;

public class Water extends Enemies {
    public static String displayText = "당신은 물을 긷으러 왔다.";
    public static int numOfOptions = 2;
    public static String[] options = new String[] {"물을 긷는다", "참지 못 하고 무장신선을 무력으로 제압하러 간다"};

    public Water() {
        super("물", 20,
                1, 10, 1, 0, false);

    }
}


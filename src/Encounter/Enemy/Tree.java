package Encounter.Enemy;

import Encounter.Enemies;

public class Tree extends Enemies {
    public static String displayText = "당신은 나무를 하러 왔다.";
    public static int numOfOptions = 2;
    public static String[] options = new String[] {"나무를 벤다", "참지 못 하고 무장신선을 무력으로 제압하러 간다"};

    public Tree() {
        super("나무", 30,
                1, 1, 1, 0, false);

    }
}

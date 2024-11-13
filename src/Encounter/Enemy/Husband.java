package Encounter.Enemy;

import Encounter.Enemies;

import java.util.Random;

public class Husband extends Enemies {
    public static String displayText = "당신은 무장신선과 싸우게 되었다. 그는 자신만만한 표정을 짓고 있다.";
    public static int numOfOptions = 3;
    public static String[] options = new String[] {"공격한다", "방어한다", "도주를 시도한다"};

    public Husband() {
        super("무장신선", 100,
                20, 20, 20, 5000, false);

    }
}

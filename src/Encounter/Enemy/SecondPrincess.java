package Encounter.Enemy;

import Encounter.Enemies;

public class SecondPrincess extends Enemies {
    public static String displayText = "바리데기의 언니인 첫 번쨰 공주가 바리데기를 방해하러 왔다.\n" +
            "공주는 부모님을 치료하는 것이 영 마음에 들지 않는 눈치이다.";
    public static int numOfOptions = 3;
    public static String[] options = new String[] {"공격한다", "방어한다", "도주를 시도한다"};

    public SecondPrincess() {
        super("첫 번쨰 공주", 150,
                50, 50, 40, 7500, false);

    }
}
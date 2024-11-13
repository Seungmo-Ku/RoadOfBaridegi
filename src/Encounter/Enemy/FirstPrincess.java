package Encounter.Enemy;

import Encounter.Enemies;

public class FirstPrincess extends Enemies {
    public static String displayText = "바리데기의 언니인 세번 쨰 공주가 바리데기를 방해하러 왔다.\n" +
            "공주는 부모님을 치료하는 것이 영 마음에 들지 않는 눈치이다.";
    public static int numOfOptions = 3;
    public static String[] options = new String[] {"공격한다", "방어한다", "도주를 시도한다"};

    public FirstPrincess() {
        super("세 번째 공주", 70,
                15, 15, 15, 2500, false);

    }
}
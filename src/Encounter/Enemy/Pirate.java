package Encounter.Enemy;

import Encounter.Enemies;

import java.util.Random;

public class Pirate extends Enemies {
    public static String displayText = "당신은 산적을 마주쳤다. 산적의 얼굴에는 적의가 가득해 보인다.";
    public static int numOfOptions = 3;
    public static String[] options = new String[] {"공격한다", "방어한다", "도주를 시도한다"};

    public Pirate() {
        super("강도", 20,
                5, 5, 5, 1000, true);
        Random rand = new Random();
        this.hp = rand.nextInt(20) + 10;
        this.power = rand.nextInt(5) + 5;
        this.dex = rand.nextInt(5) + 5;
        this.wisdom = rand.nextInt(5) + 5;
        this.money = rand.nextInt(750) + 500;
    }
}

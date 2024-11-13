package Encounter;

import java.util.Random;

public class Chest {
    public static String displayText = "길을 걸어가다가 우연히 땅에 묻혀 있는 상자를 발견했다. \n" +
            "위험할 수 있지만 동시에 도움이 될 만한 것이 있을 가능성도 존재한다.";
    public static int numOfOptions = 2;
    public static String[] options = new String[] {"열어본다", "무시하고 지나간다"};
    public static String optionsResult(int response) {
        if(response == 1) {
            Random random = new Random();
            if(random.nextBoolean()) {
                return "1 상자 안에는 돈이 들어 있었다. 당신은 돈을 500원 획득했다.";
            }else {
                return "0 상자 안에는 쥐의 시체가 들어 있었다. \n당신의 정신력이 5 감소했다.";
            }
        }
        else if(response == 2) {
            return "당신은 상자를 무시하고 지나갔다.";
        }
        return "";
    }
}

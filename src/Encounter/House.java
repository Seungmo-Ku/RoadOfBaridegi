package Encounter;

import java.util.Random;

public class House {
    public static String displayText = "당신은 우연히 산 중에 있는 집을 발견했다. 상황에 따라서 하룻동안 쉴 수 있을 것 같다.";
    public static int numOfOptions = 2;
    public static String[] options = new String[] {"문을 두드린다", "무시하고 지나간다"};
    public static String optionsResult(int response) {
        if(response == 1) {
            Random random = new Random();
            if(random.nextBoolean()) {
                return "1 당신은 다행스럽게도 좋은 집 주인을 만나 편안하게 하룻밤을 보낼 수 있었다." +
                        "\n체력을 10 회복했다. 정신력을 5 회복했다.";
            }else {
                return "0 집은 강도의 집이었고 당신은 강도와 싸울 위기에 쳐했다.";
            }
        }
        else if(response == 2) {
            return "당신은 집을 무시하고 지나갔다.";
        }
        return "";
    }
}

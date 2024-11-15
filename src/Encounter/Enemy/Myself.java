package Encounter.Enemy;

/*
1. 분열된 자아

	•	형태: 바리데기의 “포기하고 싶은 자아”와 “끝까지 버티려는 자아”가 동시에 등장하여 두 모습이 대립하는 이중적인 형태의 보스입니다.
	외형적으로는 두 인물이 끊임없이 바리데기의 선택에 대해 상반된 의견을 제시합니다.
	•	전투 방식: 두 자아가 서로 상반된 지시를 내리며 바리데기를 혼란스럽게 합니다.
	예를 들어, 포기하고 싶은 자아는 체력과 정신력을 약화시키며 포기를 종용하고, 버티려는 자아는 고통을 주지만 회복할 기회를 제공합니다.
	플레이어가 두 자아 사이에서 균형을 찾으며, 자기 결단을 통해 하나의 자아로 통합할 때 보스를 물리칠 수 있습니다.
 */

import Encounter.Enemies;

public class Myself extends Enemies {
    public static String displayText = "바리데기는 내면 속에서 포기하고 싶은 자아를 마주한다.";
    public static int numOfOptions = 3;
    public static String[] options = new String[] {"공격한다", "방어한다", "도주를 시도한다"};

    public Myself(int mental, int power, int dex, int wisdom) {
        super("포기하고 싶은 자아", 100,
                15, 15, 15, 0, false);
        this.hp = hp + (70 - mental);
        this.power = power + (70 - mental);
        this.dex = dex + (70 - mental);
        this.wisdom = wisdom + (70 - mental);
    }
}

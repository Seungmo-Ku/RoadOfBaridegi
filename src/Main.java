import Encounter.Chest;
import Encounter.Enemies;
import Encounter.Enemy.*;
import Encounter.House;
import Encounter.Merchant;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int day = 0;
    public static Baridegi baridegi = new Baridegi();
    public final static int numOfInteraction = 4;
    private static boolean gotMedicine = false;
    private static boolean killedHusband = false;
    public static void main(String[] args) {

                int response;
                displayStart("바리의 길 - 2021042988 구승모 제작",
                1, new String[]{"확인"});
                displayStart("(프롤로그)옛날 이씨 주상금마마가 7공주를 본다는 해에 왕비를 맞아들인 후 계속해서 6 공주를 낳는다. \n" +
                        "왕과 왕비는 왕자를 낳기 위해 온갖 치성을 드린 후 일곱째 아이를 잉태했으나 낳고 보니 또 공주였다.",
                        1, new String[]{"확인"});

                response = displayStart("(프롤로그)크게 노한 대왕은 일곱째 공주를 옥함에 넣어 강물에 띄워 버린다. ",
                        3, new String[]{"근처에 있는 나무를 잡으려고 노력한다", "큰 목소리로 울어본다", "아무것도 하지 않는다"});
                switch (response) {
                    case 1:
                        baridegi.addPower(5);
                        displayStart("근력이 5 올랐습니다.", 1, new String[]{"확인"});
                        break;
                    case 2:
                        baridegi.addWisdom(5);
                        displayStart("지혜가 5 올랐습니다.", 1, new String[]{"확인"});
                        break;
                    case 3:
                        baridegi.addMental(-5);
                        displayStart("당신의 무기력함으로 정신력이 5 감소합니다.", 1, new String[]{"확인"});
                }
                displayStart("(프롤로그)아기는 석가세존의 지시로 바리공덕 할아비와 할미에게 구출되어 양육된다.",
                        1, new String[]{"확인"});
                displayStart("(프롤로그)바리공주가 15세 되었을 때 대왕마마가 병이 들었는데 꿈에 청의동자가 나타나서 " +
                                "하늘이 아는 아기를 버린 죄로 죽게 되었다며 살기 위해서는 " +
                                "\n버린 아기가 구해다준 무장신선의 약려수를 먹어야 한다고 했다.",
                        1, new String[]{"확인"});
                displayStart("(프롤로그)바리공주를 찾으라는 왕명이 내려지고 한 대신의 충성으로 바리공주를 찾는다. " +
                                "바리공주는 모든 신하들과 언니들이 거절한 구약(救藥)의 길을 남장(男裝)을 하고 혼자 떠난다.... ",
                        1, new String[]{"확인"});
                day ++;

                if(args != null && args.length > 0){
                    day = Integer.parseInt(args[0]);
                    if(args[1] != null)
                        baridegi.addPower(Integer.parseInt(args[1]));
                    if(args[2] != null)
                        baridegi.addDex(Integer.parseInt(args[1]));
                    if(args[3] != null)
                        baridegi.addWisdom(Integer.parseInt(args[1]));
                }
                while(day < 30) {
                    if(day == 17) { //무장신선
                        displayMain("저승세계를 지나 신선세계에 이른 바리공주는 " +
                                "무장신선을 만나기에 이른다.", 1, new String[]{"확인"});
                        response = displayMain("무장신선은 약려수에 대한 대가로 " +
                                "나무하기 3년, 물긷기 3년, 불때기 3년 등의 일을 9년동안 해 줄 것을 요청한다.",
                                2, new String[]{"순순히 응한다", "말도 안 되니 무력으로 뺏는다"});
                        if(response == 1) { //순순히 응한다.
                            int fightBack = 0;
                            for(int i = 0; i < 5; i ++) {
                                fightBack = treeInteraction();
                                if(fightBack == 1) break;
                                baridegi.addMental(-3);
                                displayMain("반복된 일과로 " +
                                        "정신력이 3 감소합니다.", 1, new String[]{"확인"});
                                checkGameOver(baridegi);
                            }
                            if(fightBack == 0) {
                                for (int i = 0; i < 5; i++) {
                                    fightBack = waterInteraction();
                                    if (fightBack == 1) break;
                                    baridegi.addMental(-3);
                                    displayMain("반복된 일과로 " +
                                            "정신력이 3 감소합니다.", 1, new String[]{"확인"});
                                    checkGameOver(baridegi);

                                }
                            }
                            if(fightBack == 0) {
                                for (int i = 0; i < 5; i++) {
                                    fightBack = fireInteraction();
                                    if (fightBack == 1) break;
                                    baridegi.addMental(-3);
                                    displayMain("반복된 일과로 " +
                                            "정신력이 3 감소합니다.", 1, new String[]{"확인"});
                                    checkGameOver(baridegi);
                                }
                            }
                            if(fightBack == 1) {
                                husbandInteraction();
                                killedHusband = true;
                                gotMedicine = true;
                                displayMain("무장신선을 처치한 바리데기는 " +
                                        "약려수를 획득하게 된다.", 1, new String[]{"확인"});
                            }else {
                                response = displayMain("무장신선은 연이어 자신과 혼인하여 " +
                                        "아들 일곱을 낳을 것을 강요한다.", 2,
                                        new String[]{"순순히 응한다", "말도 안 되니 지금이라도 무력으로 뺏는다"});
                                if(response == 2) {
                                    husbandInteraction();
                                    killedHusband = true;
                                    gotMedicine = true;
                                    displayMain("무장신선을 처치한 바리데기는 " +
                                            "약려수를 획득하게 된다.", 1, new String[]{"확인"});
                                }else {
                                    for(int i = 1; i <= 7; i ++) {
                                        baridegi.addHp(-4);
                                        baridegi.addMental(-4);
                                        checkGameOver(baridegi);
                                        response = displayMain("당신은 무장신선과 "+i+"번 째 아이를 출산한다." +
                                                        "\n당신은 당신의 몸과 마음이 병들어 가는 것을 느낀다.\n" +
                                                        "당신의 체력이 4 감소합니다. 당신의 정신력이 4 감소합니다.", 2,
                                                new String[]{"마음을 굳게 잡고 버틴다", "지금이라도 무력으로 대항한다."});
                                        if(response == 2) {
                                            break;
                                        }
                                    }
                                    if(response == 2) {
                                        husbandInteraction();
                                        gotMedicine = true;
                                        killedHusband = true;
                                        displayMain("무장신선을 처치한 바리데기는 " +
                                                "약려수를 획득하게 된다.", 1, new String[]{"확인"});
                                    }else { //
                                        gotMedicine = true;
                                        displayMain("당신은 무장신선의 모든 요구를 들어주었고\n" +
                                                "결국 약려수를 획득하기에 이른다.", 1, new String[]{"확인"});
                                    }
                                }
                            }

                        }else {
                            husbandInteraction();
                            killedHusband = true;
                            gotMedicine = true;
                            displayMain("무장신선을 처치한 바리데기는" +
                                    "약려수를 획득하게 된다.", 1, new String[]{"확인"});
                        }
                        displayMain("바리데기는 약려수를 구한 후 부모를 살리기 위해" +
                                "다시 떠난다.", 1, new String[]{"확인"});
                    }else if(day == 10) { //첫번쨰공주
                        firstPrincessInteraction();
                    }else if(day == 24) {
                        merchantInteraction();
                    }
                    else if(day == 25) { //두번째공주
                        secondPrincessInteraction();
                    }
                    else {
                        Random rand = new Random();
                        int interactNum = rand.nextInt(numOfInteraction) + 1;
                        switch(interactNum) {
                            case 1:
                                pirateInteraction();
                                break;
                            case 2:
                                houseInteraction();
                                break;
                            case 3:
                                merchantInteraction();
                                break;
                            case 4:
                                chestInteraction();
                                break;
                        }
                    }
                    Random rand = new Random();
                    int decreaseMental = rand.nextInt(30) - baridegi.getWisdom();
                    if(decreaseMental < 0) decreaseMental = 0;
                    baridegi.addMental(-decreaseMental);
                    if(decreaseMental > 0)
                        displayMain("고된 하루로 바리데기의 정신력이 " +decreaseMental+" 감소합니다.\n" +
                                        "지혜를 높이면 정신력 감소를 줄일 수 있습니다.",
                            1, new String[]{"확인"});
                    day ++;

                    if(baridegi.getMental() <= 0 || baridegi.getHp() <= 0) {
                        gameOver();
                    }
                }
                displayStart("(에필로그)이윽고 바리데기는 약려수를 가지고 부모에게 도착한다.",
                1, new String[]{"확인"});
                displayStart("(에필로그)하지만 이미 양전마마는 승하해 장사를 지내려는 중이었다.",
                1, new String[]{"확인"});
                displayStart("바리데기는 절망 속에서 두 가지 자아로 분열한다.",
                1, new String[]{"확인"});
                displayStart("끝까지 버티려는 바리데기의 자아는 포기하고 싶은 자아를 마주하게 된다.",
                1, new String[]{"확인"});
                myselfInteraction(baridegi);

                    displayStart("(에필로그)바리데기는 상여를 멈추게 하고 약수와 꽃으로 양전마마를 살린다.",
                            1, new String[]{"확인"});

                    if(killedHusband)
                        displayStart("(에필로그)살아난 대왕마마는 바리공주의 소원을 들어 그녀를 만신(萬神)의 왕이 되게 한다.",
                            1, new String[]{"확인"});
                    else {
                        displayStart("(에필로그)살아난 대왕마마는 바리공주의 소원을 들어 그녀를 만신(萬神)의 왕이 되게 하고,",
                                1, new String[]{"확인"});
                        displayStart("(에필로그)무장신선은 죽은 사람이 가는 길에서 노제(路祭)를 받아 먹게 하고, " +
                                        "일곱 아들은 저승의 십대왕(十大王)이 되게 한다.",
                                1, new String[]{"확인"});

                    }
                    displayStart("Happy Ending",
                            1, new String[]{"확인"});

                


    }
    private static void checkGameOver(Baridegi baridegi) {
        if(baridegi.getHp() <= 0 || baridegi.getMental() <= 0)
            gameOver();
    }
    private static void attack(Baridegi baridegi, Enemies enemies) {
        Random rand = new Random();
        if(enemies.isStunned()) {
            enemies.addHp(-baridegi.getPower());
            enemies.setStunned(false);
        }else if(baridegi.getDex() >= enemies.getDex()) {
            enemies.addHp(-baridegi.getPower());
            if(enemies.getHp() > 0) {
                if(enemies.getPower() < 5)
                    baridegi.addHp(-enemies.getPower());
                else baridegi.addHp(-(enemies.getPower() +
                        rand.nextInt(enemies.getPower() / 4) - enemies.getPower() / 8));
            }
        }else {
            baridegi.addHp(-(enemies.getPower() +
                    rand.nextInt(enemies.getPower() / 4) - enemies.getPower() / 8));
            enemies.addHp(-baridegi.getPower());
        }
    }
    private static void defense(Baridegi baridegi, Enemies enemies) {
        Random random = new Random();
        int bariStat = baridegi.getDex() * 2 + baridegi.getWisdom() + random.nextInt(10);
        int enemyStat = enemies.getDex() * 2 + enemies.getWisdom() + random.nextInt(10);
        if(bariStat >= enemyStat) {
            enemies.setStunned(true);
            displayMain("당신은 " + enemies.getName() + "의 공격을 성공적으로 방어했다" +
                    "\n상대방은 잠시동안 기절하였다.", 1, new String[]{"확인"});
        }else {
            baridegi.addHp(-enemies.getPower());
            displayMain("당신은 " + enemies.getName() + "의 공격을 방어하지 못했다." +
                    "\n당신의 체력이 감소합니다.", 1, new String[]{"확인"});
        }
    }
    private static boolean escape(Baridegi baridegi, Enemies enemies) {
        Random random = new Random();
        int bariStat = baridegi.getDex() + baridegi.getWisdom()*2 + random.nextInt(10);
        int enemyStat = enemies.getDex() + enemies.getWisdom()*2 + random.nextInt(20);
        if(bariStat >= enemyStat && enemies.isEscapable()) {
            return true;
        }else {
            baridegi.addHp(-enemies.getPower());
            displayMain("당신은 성공적으로 도망가지 못 했다." +
                    "\n당신의 체력이 감소합니다.", 1, new String[]{"확인"});
            return false;
        }
    }
    private static int treeInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Tree tree = new Tree();
        while(tree.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            response = displayMain(Tree.displayText +
                            "\n체력 : "+tree.getHp()+", 근력 : "+tree.getPower()+", 민첩 : "+tree.getDex(),
                    Tree.numOfOptions, Tree.options);
            switch (response) {
                case 1:
                    attack(baridegi, tree);
                    break;
                case 2:
                    return 1;
            }
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            enemyDie(baridegi, tree);
        }
        return 0;

    }
    private static int waterInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Water water = new Water();
        while(water.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            response = displayMain(Water.displayText +
                            "\n체력 : "+water.getHp()+", 근력 : "+water.getPower()+", 민첩 : "+water.getDex(),
                    Water.numOfOptions, Water.options);
            switch (response) {
                case 1:
                    attack(baridegi, water);
                    break;
                case 2:
                    return 1;
            }
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            enemyDie(baridegi, water);
        }
        return 0;

    }
    private static int fireInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Fire fire = new Fire();
        while(fire.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
                response = displayMain(Fire.displayText +
                                "\n체력 : "+fire.getHp()+", 근력 : "+fire.getPower()+", 민첩 : "+fire.getDex(),
                        Fire.numOfOptions, Fire.options);
            switch (response) {
                case 1:
                    attack(baridegi, fire);
                    break;
                case 2:
                    return 1;
            }
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            enemyDie(baridegi, fire);
        }
        return 0;

    }
    private static void myselfInteraction(Baridegi baridegi) {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Myself myself = new Myself(baridegi.getMental(), baridegi.getPower(), baridegi.getDex(), baridegi.getWisdom());
        boolean isEscaped = false;
        while(myself.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            if(myself.isStunned()) {
                response = displayMain(Myself.displayText + "상대방은 잠시 기절할 것 같다." +
                                "\n체력 : "+ myself.getHp()+", 근력 : "+myself.getPower()+", 민첩 : " + myself.getDex(),
                        Myself.numOfOptions, Myself.options);
            }else {
                response = displayMain(Myself.displayText +
                                "\n체력 : "+ myself.getHp()+", 근력 : "+myself.getPower()+", 민첩 : " + myself.getDex(),
                        Myself.numOfOptions, Myself.options);
            }

            switch (response) {
                case 1:
                    attack(baridegi, myself);
                    break;
                case 2:
                    defense(baridegi, myself);
                    break;
                case 3:
                    isEscaped = escape(baridegi, myself);
                    break;
            }
            if(isEscaped) {break;}
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            if(!isEscaped) enemyDie(baridegi, myself);
            else successfullyEscaped(baridegi, myself);
        }

    }
    private static void firstPrincessInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        FirstPrincess firstPrincess = new FirstPrincess();
        boolean isEscaped = false;
        while(firstPrincess.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            if(firstPrincess.isStunned()) {
                response = displayMain(FirstPrincess.displayText + "상대방은 잠시 기절할 것 같다." +
                                "\n체력 : "+ firstPrincess.getHp()+", 근력 : ???, 민첩 : ???",
                        FirstPrincess.numOfOptions, FirstPrincess.options);
            }else {
                response = displayMain(FirstPrincess.displayText +
                                "\n체력 : "+firstPrincess.getHp()+", 근력 : ???, 민첩 : ???",
                        FirstPrincess.numOfOptions, FirstPrincess.options);
            }

            switch (response) {
                case 1:
                    attack(baridegi, firstPrincess);
                    break;
                case 2:
                    defense(baridegi, firstPrincess);
                    break;
                case 3:
                    isEscaped = escape(baridegi, firstPrincess);
                    break;
            }
            if(isEscaped) {break;}
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            if(!isEscaped) enemyDie(baridegi, firstPrincess);
            else successfullyEscaped(baridegi, firstPrincess);
        }

    }
    private static void secondPrincessInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        SecondPrincess secondPrincess = new SecondPrincess();
        boolean isEscaped = false;
        while(secondPrincess.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            if(secondPrincess.isStunned()) {
                response = displayMain(SecondPrincess.displayText + "상대방은 잠시 기절할 것 같다." +
                                "\n체력 : "+ secondPrincess.getHp()+", 근력 : ???, 민첩 : ???",
                        SecondPrincess.numOfOptions, SecondPrincess.options);
            }else {
                response = displayMain(SecondPrincess.displayText +
                                "\n체력 : "+secondPrincess.getHp()+", 근력 : ???, 민첩 : ???",
                        SecondPrincess.numOfOptions, SecondPrincess.options);
            }

            switch (response) {
                case 1:
                    attack(baridegi, secondPrincess);
                    break;
                case 2:
                    defense(baridegi, secondPrincess);
                    break;
                case 3:
                    isEscaped = escape(baridegi, secondPrincess);
                    break;
            }
            if(isEscaped) {break;}
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            if(!isEscaped) enemyDie(baridegi, secondPrincess);
            else successfullyEscaped(baridegi, secondPrincess);
        }

    }
    private static void husbandInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Husband husband = new Husband();
        boolean isEscaped = false;
        while(husband.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            if(husband.isStunned()) {
                response = displayMain(Husband.displayText + "상대방은 잠시 기절할 것 같다." +
                        "\n체력 : "+husband.getHp()+", 근력 : ???, 민첩 : ???",
                        Husband.numOfOptions, Husband.options);
            }else {
                response = displayMain(Husband.displayText +
                        "\n체력 : "+husband.getHp()+", 근력 : ???, 민첩 : ???",
                        Husband.numOfOptions, Husband.options);
            }

            switch (response) {
                case 1:
                    attack(baridegi, husband);
                    break;
                case 2:
                    defense(baridegi, husband);
                    break;
                case 3:
                    isEscaped = escape(baridegi, husband);
                    break;
            }
            if(isEscaped) {break;}
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            if(!isEscaped) enemyDie(baridegi, husband);
            else successfullyEscaped(baridegi, husband);
        }

    }
    private static void pirateInteraction() {   //공격한다, 방어를 시도한다, 도망을 시도한다
        Pirate pirate = new Pirate();
        boolean isEscaped = false;
        while(pirate.getHp() > 0 && baridegi.getHp() > 0) {
            int response = 1;
            if(pirate.isStunned()) {
                response = displayMain(Pirate.displayText + "상대방은 잠시 기절할 것 같다." +
                        "\n체력 : "+pirate.getHp()+", 근력 : "
                        +pirate.getPower()+", 민첩 : "+pirate.getDex(), Pirate.numOfOptions, Pirate.options);
            }else {
                response = displayMain(Pirate.displayText +
                        "\n체력 : "+pirate.getHp()+", 근력 : "
                        +pirate.getPower()+", 민첩 : "+pirate.getDex(), Pirate.numOfOptions, Pirate.options);
            }

            switch (response) {
                case 1:
                    attack(baridegi, pirate);
                    break;
                case 2:
                    defense(baridegi, pirate);
                    break;
                case 3:
                    isEscaped = escape(baridegi, pirate);
                    break;
            }
            if(isEscaped) {break;}
        }
        if(baridegi.getHp() <= 0) { //패배
            gameOver();
        }else {
            if(!isEscaped) enemyDie(baridegi, pirate);
            else successfullyEscaped(baridegi, pirate);
        }

    }
    private static void enemyDie(Baridegi baridegi, Enemies enemies) {
        baridegi.addMoney(enemies.getMoney());
        displayMain("당신은 "+enemies.getName()+"을 성공적으로 무찔렀다. " +
                enemies.getMoney() + "원을 획득했다.", 1, new String[]{"확인"});
        Random rand = new Random();
        int reward = rand.nextInt(3);
        int num = rand.nextInt(10) + 1;
        switch(reward) {
            case 0:
                baridegi.addPower(num);
                displayMain("또한 전투의 경험으로 근력을 "+num+" 획득했다.", 1, new String[]{"확인"});
                break;
            case 1:
                baridegi.addDex(num);
                displayMain("또한 전투의 경험으로 민첩을 "+num+" 획득했다.", 1, new String[]{"확인"});
                break;
            case 2:
                baridegi.addWisdom(num);
                displayMain("또한 전투의 경험으로 지혜를 "+num+" 획득했다.", 1, new String[]{"확인"});
                break;
        }
    }
    private static void successfullyEscaped(Baridegi baridegi, Enemies enemies) {
        displayMain("바리데기는 "+enemies.getName()+"으로부터 성공적으로 도망칠 수 있었다.", 1,
                new String[] {"확인"});
    }
    private static void houseInteraction() {
        int response = displayMain(House.displayText, House.numOfOptions, House.options);
        String result = House.optionsResult(response);
        if(response == 2) {
            displayMain(result, 1, new String[] {"확인"});
        }
        else {
            if (Integer.parseInt(result.substring(0, 1)) == 1) { //좋은 사람
                baridegi.addHp(10);
                baridegi.addMental(5);
                displayMain(result.substring(2, result.length()), 1, new String[]{"확인"});
            } else { //강도 만남
                displayMain(result.substring(2, result.length()), 1, new String[]{"확인"});
                pirateInteraction();
            }

        }
    }
    private static void merchantInteraction() {
        int response = displayMain(Merchant.displayText, Merchant.numOfOptions, Merchant.options);
        switch(response) {
            case 5:
                displayMain("당신은 상인에게서 아무것도 사지 않기로 했다.", 1, new String[]{"확인"});
                break;
            case 1:
                if(baridegi.getMoney() >= 500) {
                    baridegi.addMoney(-500);
                    baridegi.addHp(-5);
                    baridegi.addMental(10);
                    displayMain("당신은 상인에게서 술을 구매해서 마셨다.\n한결 마음이 편해졌다.\n돈 - 500, 체력 - 5, 정신력 + 10", 1, new String[]{"확인"});
                }else {
                    displayMain("돈이 부족합니다.", 1, new String[]{"확인"});
                    merchantInteraction();
                }
                break;
            case 2:
                if(baridegi.getMoney() >= 500) {
                    baridegi.addMoney(-500);
                    baridegi.addWisdom(5);
                    displayMain("당신은 상인에게서 책을 구매하여 읽었다.\n세상에 대한 깨달음을 얻었다..\n돈 - 500, 지혜 + 5", 1, new String[]{"확인"});
                }else {
                    displayMain("돈이 부족합니다.", 1, new String[]{"확인"});
                    merchantInteraction();
                }
                break;
            case 3:
                if(baridegi.getMoney() >= 500) {
                    baridegi.addMoney(-500);
                    baridegi.addHp(10);
                    displayMain("당신은 상인에게서 밥을 구매하여 먹었다.\n허기를 달랠 수 있었다..\n돈 - 500, 체력 + 10", 1, new String[]{"확인"});
                }else {
                    displayMain("돈이 부족합니다.", 1, new String[]{"확인"});
                    merchantInteraction();
                }
                break;
            case 4:
                if(baridegi.getMoney() >= 1000) {
                    baridegi.addMoney(-1000);
                    baridegi.addPower(5);
                    displayMain("당신은 상인에게서 무기를 구매했다.\n한층 더 전투에 대비할 수 있었다.\n돈 - 1000, 근력 + 5", 1, new String[]{"확인"});
                }else {
                    displayMain("돈이 부족합니다.", 1, new String[]{"확인"});
                    merchantInteraction();
                }
                break;
        }
        if(day == 24) {
            merchantInteraction();
        }
    }
    private static void chestInteraction() {
        int response = displayMain(Chest.displayText, Chest.numOfOptions, Chest.options);
        String result = Chest.optionsResult(response);
        if(response == 2) {
            displayMain(result, 1, new String[] {"확인"});
        }
        else {
            if (Integer.parseInt(result.substring(0, 1)) == 0) {
                baridegi.addMental(-5);

            } else {
                baridegi.addMoney(500);
            }
            displayMain(result.substring(2, result.length()), 1, new String[]{"확인"});
        }
    }
    private static int getResponse(int numOfOption) {
        Scanner scanner = new Scanner(System.in);
        int response = -1;
        while(response < 1 || response > numOfOption) {

            try {
                response = scanner.nextInt();
                if(response == 20241103) {
                    baridegi.addMoney(1000);
                    response = -1;
                } //치트
                if(response >= 1 && response <= numOfOption) {
                    return response;
                }
            } catch (InputMismatchException e) {
                System.out.print("\033[1A\033[2K"); // 현재 줄을 지움
                System.out.print("\r"); // 커서를 줄 시작으로 이동
                System.out.printf("당신의 선택은) "); // 새로운 체력 정보 출력
                System.out.flush(); // 즉시 출력
                response  = scanner.nextInt();
            }
            System.out.print("\033[1A\033[2K"); // 현재 줄을 지움
            System.out.print("\r"); // 커서를 줄 시작으로 이동
            System.out.printf("당신의 선택은) "); // 새로운 체력 정보 출력
            System.out.flush(); // 즉시 출력
        }
        return response;
    }
    private static int displayStart(String encounter, int numOfOption, String[] options) {
        System.out.print("\033[H\033[2J"); // 화면 초기화.
        System.out.flush();
        textWaiting(500);
        System.out.println("\n" + encounter);
        System.out.println("\n\n\n");
        textWaiting(700);

        return displayOption(numOfOption, options);
    }
    private static int displayMain(String encounter, int numOfOption, String[] options) {
        System.out.print("\033[H\033[2J"); // 화면 초기화.
        System.out.flush();
        System.out.printf("=== Day %d ===\n", day);
        textWaiting(500);
        System.out.println(encounter);
        System.out.println("\n\n\n");
        textWaiting(700);
        displayStatus();

        return displayOption(numOfOption, options);
    }
    private static void displayStatus() {
        System.out.printf("체력: %d | 정신력: %d | 돈: %d | 근력: %d | 민첩: %d | 지혜: %d | 운: %d\n",
                baridegi.getHp(), baridegi.getMental(), baridegi.getMoney(), baridegi.getPower(),
                baridegi.getDex(), baridegi.getWisdom(), baridegi.getLuck()); // 상태 정보를 항상 하단에 표시
    }
    private static int displayOption(int numOfOption, String[] options) {
        System.out.print("|   ");
        for(int i = 0; i < numOfOption; i++) {
            System.out.printf("%d. %s   |   ", i+1, options[i]);
        }
        System.out.print("\n당신의 선택은) ");
        return getResponse(numOfOption);
    }
    private static void textWaiting(int time) {
        try {
            Thread.sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void gameOver() {
        if(day == 30) {
            displayStart("(에필로그)정신이 피폐해질 대로 피폐해진 바리데기는 " +
                            "아무런 생각이 들지 않았다.",
                    1, new String[]{"확인"});
            displayStart("(에필로그)그저 멍하니 양전마마의 상여를 지켜 볼 뿐이었다.",
                    1, new String[]{"확인"});
            displayStart("Sad Ending",
                    1, new String[]{"확인"});
        }
        else if(baridegi.getHp() <= 0) {
            displayStart("바리데기는 체력의 고갈로 쓰러지고 말았습니다.\n" +
                    "당신의 바리데기는 "+day+"일 동안 생존했습니다.", 1, new String[]{"종료"});
        } else {
            displayStart("바리데기는 정신력 고갈로 나아갈 힘을 잃어버리고 말았습니다.\n" +
                        "당신의 바리데기는 "+day+"일 동안 생존했습니다.", 1, new String[]{"종료"});
        }
        System.exit(0);
    }
}
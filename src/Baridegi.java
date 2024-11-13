public class Baridegi {

    private int hp, mental, money;
    private int power, dex, wisdom, luck;

    public Baridegi() {
        hp = 100;
        mental = 100;
        money = 0;
        power = 5;
        dex = 5;
        wisdom = 5;
        luck = 5;
    }

    public int getHp() {
        return hp;
    }

    public void addHp(int hp) {
        this.hp += hp;
        if(this.hp > 100) {this.hp = 100;}
    }

    public int getMental() {
        return mental;
    }

    public void addMental(int mental) {
        this.mental += mental;
        if(this.mental > 100) {this.mental = 100;}
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
        if(this.money < 0) {this.money = 0;}
    }

    public int getPower() {
        return power;
    }

    public void addPower(int power) {
        this.power += power;
    }

    public int getDex() {
        return dex;
    }

    public void addDex(int dex) {
        this.dex += dex;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void addWisdom(int wisdom) {
        this.wisdom += wisdom;
    }

    public int getLuck() {
        return luck;
    }

    public void addLuck(int luck) {
        this.luck += luck;
    }
}

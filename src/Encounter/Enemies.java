package Encounter;

public class Enemies {
    protected String name;
    protected int hp;
    protected int power;
    protected int dex;
    protected int wisdom;
    protected int money;
    protected boolean isEscapable;
    protected boolean isStunned = false;

    public Enemies(String name, int hp, int power, int dex, int wisdom, int money, boolean isEscapable) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.dex = dex;
        this.wisdom = wisdom;
        this.money = money;
        this.isEscapable = isEscapable;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void addHp(int hp) {
        this.hp += hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public boolean isEscapable() {
        return isEscapable;
    }

    public int getMoney() {
        return money;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }
}

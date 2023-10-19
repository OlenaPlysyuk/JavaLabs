package droid;

public class Droid {
    protected int health;
    protected int damage;
    protected int cr_chance;
    protected String name;
    public Droid() {}

    public Droid(int health, int damage, int cr_chance,String name) {
        this.health = health;
        this.damage = damage;
        this.cr_chance = cr_chance;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCr_chance() {
        return cr_chance;
    }

    public void setCr_chance(int cr_chance) {
        this.cr_chance = cr_chance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

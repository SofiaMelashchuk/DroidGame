package droids;

import java.text.DecimalFormat;
import java.util.Random;

public class Droid {
    protected final String name;
    protected double health;
    protected double damage;

    public Droid(String name, double health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHit(double damage) {
        Random random = new Random();

        double actualDamage = random.nextDouble(damage);
        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(health);
        return name + " health = " + result;
    }
}
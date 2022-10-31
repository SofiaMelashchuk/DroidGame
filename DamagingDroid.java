package droids;

public class DamagingDroid extends Droid {
    public double damageMultiplier = 1.5;
    public DamagingDroid(String name, double health, double damage) {
        super(name, health, damage);
        this.damage = damage * damageMultiplier;
    }
}


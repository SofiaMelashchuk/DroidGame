package droids;

public class SpecialDroid extends Droid {
    double armourMultiplier = 0.8;
    public SpecialDroid (String name, double health, int damage) {
        super(name, health, damage);
    }
    @Override
    public double getHit(double damage) {
        return super.getHit(damage * armourMultiplier);
    }
}

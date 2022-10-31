package droids;

public class HealthyDroid extends Droid {
    public int healthy = 10;
    public HealthyDroid (String name, double health, int damage) {
        super(name, health, damage);
        this.health = health + healthy;
    }
}

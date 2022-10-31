package arena;
import droids.Droid;
import java.text.DecimalFormat;
import java.util.Random;

public class Arena {
    private final Droid firstPlayer;
    private final Droid secondPlayer;
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public Arena(Droid firstPlayer, Droid secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }
    private void prepareRound() {
        initFighters();
        currentRound++;
        var roundText = "\n-----------------Round " + currentRound + "-----------------";
        System.out.println(roundText);
        FileWorker.writeIntoFile(roundText, true);
    }
    public Droid startFight() {
        do {
            prepareRound();
            double actualDamage = doFight();
            printRoundInfo(actualDamage);

        } while (defender.isAlive());

        return attacker;
    }

    private double doFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(double actualDamage) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(actualDamage);
        var hitInfo = defender.getName() + " get hit with " + result + " damage";
        var defenderInfo = "Defender " + defender;
        var attackerInfo = "Attacker " + attacker;
        System.out.println(hitInfo);
        System.out.println(defenderInfo);
        System.out.println(attackerInfo);

        FileWorker.writeIntoFile(hitInfo, true);
        FileWorker.writeIntoFile(defenderInfo, true);
        FileWorker.writeIntoFile(attackerInfo, true);
    }

    private void initFighters() {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = firstPlayer;
            defender = secondPlayer;
        } else {
            attacker = secondPlayer;
            defender = firstPlayer;
        }
    }
}

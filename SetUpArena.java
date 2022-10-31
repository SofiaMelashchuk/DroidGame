package arena;

import droids.*;
import droids.SpecialDroid;
import droids.DamagingDroid;
import teams.Team;

import java.util.Scanner;

public class SetUpArena {
    Droid droid1 = null;
    Droid droid2 = null;
    public void chooseBattleMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, choose Battle Mode! ");
        System.out.println("Press 1 if 1x1");
        System.out.println("Press 2 if team vs team");
        System.out.println("Press 3 if open the completed battle");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                setUpDroids();
                askWritePermission();
                startFight();
            }
            case 2 -> {
                setUpTeams();
                askWritePermission();
                startFight();
            }
            case 3 -> {
                FileWorker.printLastSavedFight();
            }
            default -> System.out.println("Mistake");
        }
    }

    private Droid getDroid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 if Healthy Droid");
        System.out.println("Press 2 if Precise Droid");
        System.out.println("Press 3 if Special Droid");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("______Your choice is Healthy Droid______");
                return new HealthyDroid("h300", 50, 10);
            }
            case 2 -> {
                System.out.println("______Your choice is Precise Droid______");
                return new DamagingDroid("p200", 50, 10);
            }
            case 3 -> {
                System.out.println("Your choice is Special Droid");
                return new SpecialDroid("s100", 50, 10);
            }
            default -> System.out.println("Mistake");
        }
        return null;
    }
    private Droid getTeam() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("______Your choice is Healthy Team______");
                return new Team("TEAM hh90", 120, 20);
            }
            case 2 -> {
                System.out.println("______Your choice is Healthy Damaging Team______");
                return new Team("TEAM hd67", 110, 25);
            }
            case 3 -> {
                System.out.println("______Your choice is Healthy Special Team______");
                return new Team("TEAM hs89", 110, 20);
            }
            case 4 -> {
                System.out.println("______Your choice is Damaging Team______");
                return new Team("TEAM dd59", 100, 30);
            }
            case 5 -> {
                System.out.println("______Your choice is Damaging Special Team______");
                return new Team("TEAM ds83", 100, 25);
            }
            case 6 -> {
                System.out.println("______Your choice is Special Team______");
                return new Team("TEAM ss94", 100, 20);
            }
            default -> System.out.println("Mistake");
        }
        return null;
    }

    private void setUpDroids() {
        System.out.println("_______Your choice is 1x1, choose first droid_______");
        droid1 = getDroid();
        System.out.println("\nChoose second droid");
        droid2 = getDroid();
    }
    private void setUpTeams() {
        System.out.println("_______Your choice is team battle, create first team_______");

        System.out.println("Press 1 if Healthy + Healthy");
        System.out.println("Press 2 if Healthy + Damaging");
        System.out.println("Press 3 if Healthy + Special");
        System.out.println("Press 4 if Damaging + Damaging");
        System.out.println("Press 5 if Damaging + Special");
        System.out.println("Press 6 if Special + Special");

        droid1 = getTeam();
        System.out.println("Create second team");
        droid2 = getTeam();
    }
    private void startFight() {
        if (droid1 == null || droid2 == null) {
            System.out.println("SetUp your droids before fighting");
            return;
        }
        Arena arena = new Arena(droid1, droid2);
        Droid winner = arena.startFight();
        var winnerText = "-------------------------------" + "\n" + "The winner is " + winner.getName();
        System.out.println(winnerText);
        FileWorker.writeIntoFile(winnerText, true);
    }

    private void askWritePermission() {
        System.out.println("Do you want to save your battle? 1 if yes, 2 if no:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            FileWorker.setWriteAllowed(true);
            FileWorker.clearFile();
        } else {
            FileWorker.setWriteAllowed(false);
        }
    }
}

package arena;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorker {
    private static final String fileName = "FightLog.txt";
    private static boolean writeAllowed = true;

    public static void setWriteAllowed(boolean state) {
        writeAllowed = state;
    }
    public static void clearFile() {
        writeIntoFile("", false);
    }
    public static void writeIntoFile(String line, boolean append) {
        if (!writeAllowed) {
            return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
            if (append) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("[Error] writeIntoFile " + ex.getLocalizedMessage());
        }
    }

    public static void printLastSavedFight() {
        try {
            String text = Files.readString(Paths.get(fileName));
            System.out.println(text);
        } catch (Exception ex) {
            System.out.println("[Error] printLastSavedFight " + ex);
        }
    }
}


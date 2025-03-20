package chap17;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Exercise17_01 {
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("Exercise17_01.txt");
        boolean exists = file.exists();
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new FileOutputStream(file, true)); ) {
            if (exists)
                writer.print(" ");
            for (int i = 0; i < 100; i++) {
                int rand = (int)(Math.random() * 999) + 1; //1-999
                writer.print(rand);
                if (i < 99)
                    writer.print(" ");
            }
        }
        java.util.Scanner scanner = new Scanner(file);
        System.out.printf("\t\t[-------Exercise17_01.txt-------]\n%s", "\t\t|\t\t\t\t|\n".repeat(3));
        int num = 1;
        while (scanner.hasNextInt())
            System.out.printf("\t\t[\tInt %-8s %3d\t]\n", "#" + num++ + ":", scanner.nextInt());
        System.out.printf("%s\t\t[----------End of File----------]\n", "\t\t|\t\t\t\t|\n".repeat(3));
    }
}

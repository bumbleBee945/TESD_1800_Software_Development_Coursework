package chap17;

import java.io.*;

public class Exercise17_03 {
    public static void main(String[] args) throws Exception {

        java.io.File file = new java.io.File("Exercise17_03.dat");
        boolean exists = file.exists();
        try (DataOutputStream writer = new DataOutputStream(new FileOutputStream(file, true)); ) {
            if (exists)
                writer.writeChar(' ');

            for (int i = 0; i < 100; i++) {
                int rand = (int)(Math.random() * 900) + 100; //100-999
                writer.writeInt(rand);
                if (i < 99)
                    writer.writeChar(' ');
            }
        }

        DataInputStream reader = new DataInputStream(new FileInputStream(file));

        System.out.printf("\t\t[-------Exercise17_03.dat-------]\n%s", "\t\t|\t\t\t\t|\n".repeat(3));
        int num = 1;

        try {
            while (true) {
                System.out.printf("\t\t[\tInt %-8s %3d\t]\n", "#" + num++ + ":", reader.readInt());
                reader.readChar();
            }

        } catch (IOException e) {
            System.out.printf("%s\t\t[----------End of File----------]\n", "\t\t|\t\t\t\t|\n".repeat(3));
        }
    }
}

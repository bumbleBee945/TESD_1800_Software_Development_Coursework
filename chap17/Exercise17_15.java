package chap17;


import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Input file (encoded):\n[-] "); //make files
        File inputFile = new File(input.nextLine());
        System.out.print("Output file (decoded):\n[-] ");
        File outputFile = new File(input.nextLine());

        int read = 0; //decode
        try (
                DataOutputStream writer = new DataOutputStream(new FileOutputStream(outputFile, true));
                DataInputStream reader = new DataInputStream(new FileInputStream(inputFile));
        ) {
            int r = 0;
            while ((r = reader.read()) != -1) {
                writer.write((byte)r - 5);
                read++;
                System.out.println("Decoded #" + read);
            }
        } catch (Exception ex) {
            System.out.printf("Finished.\n(Decoded %d bytes.)\n", read);
        }

        System.out.print("Read output file? y/n\n[-] ");
        if (input.nextLine().equalsIgnoreCase("y")) {
            try (
                DataInputStream outputReader = new DataInputStream(new FileInputStream(outputFile));
            ) {
                int r = 0;
                while ((r = outputReader.read()) != -1)
                    System.out.print((char)((byte)r));
            } catch (Exception ex) {
                System.out.print("End of file.");
            }
        }

    }
}

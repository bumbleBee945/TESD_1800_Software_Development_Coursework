import java.util.Scanner;
import java.util.Arrays;

public class Exercise12_15 {
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("intFile");
        if (file.exists()) {
            System.out.print("intFile.txt already exists.\n");
            System.exit(1);
        } else
            System.out.print("Creating intFile.txt ...\n");
        try (
            java.io.PrintWriter output = new java.io.PrintWriter(file);
        ) {
            output.printf("%d", 10 + (int)(Math.random() * 90)); //10-99
            for (int i = 0; i < 99; i++)
                output.printf(" %d", 10 + (int)(Math.random() * 90)); //10-99
        }
        Scanner input = new Scanner(file);
        System.out.print("\t  Unsorted:\n");
        for (int i = 0; i < 4; i++) {
            System.out.print("\t| ");
            for (int j = 0; j < 25; j++)
                System.out.printf("%d ", input.nextInt());
            System.out.print("|\n");
        }
        input = new Scanner(file);
        System.out.print("\t  Sorted:\n");
        int[] tempArray = new int[100];
        for (int i = 0; i < 100; i++)
            tempArray[i] = input.nextInt();
        Arrays.sort(tempArray);
        int spot = 0;
        for (int i = 0; i < 4; i++) {
            System.out.print("\t| ");
            for (int j = 0; j < 25; j++)
                System.out.printf("%d ", tempArray[spot++]);
            System.out.print("|\n");
        }
    }
}

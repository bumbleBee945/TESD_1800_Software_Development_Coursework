package chap17;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */

import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        outputData(new FileInputStream("Exercise17_07.dat"));
    }
    public static void outputData(FileInputStream fis) {
        double loanAmt = 0.0;
        try (
                ObjectInputStream input = new ObjectInputStream(fis);
        ) {
                while (true)
                    loanAmt += ((Loan)input.readObject()).getLoanAmount();
        } catch (Exception ex) {
            System.out.print("\t-\t-\t-\t-\n\tTotal loan amount is " + loanAmt + ".\n\t-\t-\t-\t-\n");
        }
    }
}

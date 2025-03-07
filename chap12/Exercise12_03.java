/*
Author: Aiden Olsen
Date: 03/07/2025

This program is for an exception catching example
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise12_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> intArrayList = new ArrayList<>();
        int givenValue;
        String clearInput;
        for (int i = 0; i < 100; i++)
            intArrayList.add((int)(Math.random() * 101));
        while (true) {
            System.out.print("[!!] 100-element array made\n[!!] Input an index, or -1 to exit\n[#?] ");
            try {
                givenValue = input.nextInt();
                if (givenValue == -1)
                    break;
                System.out.printf("[%d] - %d\n\n", givenValue, intArrayList.get(givenValue));
            } catch (IndexOutOfBoundsException ex) {
                System.out.print("[XX] Invalid input. Must be -1 to 99.\n\n");
            } catch (InputMismatchException ex) {
                System.out.print("[XX] Invalid input. Must be an integer.\n\n");
                clearInput = input.nextLine();
            }
        }
    }
}
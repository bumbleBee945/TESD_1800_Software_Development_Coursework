import java.util.Scanner;

public class Exercise10_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        String inputLine;
        int value1;
        MyInteger value2;
        MyInteger myInt1;
        MyInteger myInt2;
        while (true) {
            System.out.print("[1] Test MyInteger static methods\n[2] Test MyInteger objects\n[-] ");
            inputLine = input.nextLine();
            option = MyInteger.parseInt(inputLine);
            if (option == 1) {
                System.out.print("This is a test of the MyInteger static methods.\n");
                System.out.print("Please input an integer: ");
                inputLine = input.nextLine();
                value1 = MyInteger.parseInt(inputLine);
                System.out.printf("Your given integer is %d.\n", value1);
                System.out.printf("%d is %sprime and %s.\n", value1, (MyInteger.isPrime(value1) == true ? "" : "not "), (MyInteger.isOdd(value1) == true ? "odd" : "even"));
                System.out.printf("Input an integer to compare to %d: ", value1);
                inputLine = input.nextLine();
                value2 = new MyInteger(MyInteger.parseInt(inputLine));
                System.out.printf("Your given integer is %d.\n", value2.getInteger());
                System.out.printf("%d is %sprime and %s.\n", value2.getInteger(), (MyInteger.isPrime(value2.getInteger()) == true ? "" : "not "), (MyInteger.isOdd(value2.getInteger()) == true ? "odd" : "even"));
                System.out.printf("%d is %sthe same as %d.\n", value1, (value2.equals(value1) == true ? "" : "not "), value2.getInteger());
                System.out.print("That is all for this test.\n\n\nTo test again, press Enter.\n");
                inputLine = input.nextLine();
            } else if (option == 2) {
                System.out.print("This is a test of the MyInteger object.\n\n");
                System.out.print("Please input an integer: ");
                inputLine = input.nextLine();
                myInt1 = new MyInteger(MyInteger.parseInt(inputLine));
                System.out.print("Please, give me another: ");
                inputLine = input.nextLine();
                myInt2 = new MyInteger(MyInteger.parseInt(inputLine));
                System.out.printf("Got it. Your two integers are %d and %d.\n\n", myInt1.getInteger(), myInt2.getInteger());
                System.out.printf("%d is %sprime and %s.\n", myInt1.getInteger(), (myInt1.isPrime() == true ? "" : "not "), (myInt1.isEven() == true ? "even" : "odd"));
                System.out.printf("%d is %sprime and %s.\n", myInt2.getInteger(), (myInt2.isPrime() == true ? "" : "not "), (myInt2.isOdd() == true ? "odd" : "even"));
                System.out.printf("%d is %sthe same as %d.\n\n", myInt1.getInteger(), (myInt1.equals(myInt2) == true ? "" : "not "), myInt2.getInteger());
                System.out.printf("%d + %d = %d.\n\n\n", myInt1.getInteger(), myInt2.getInteger(), (myInt1.getInteger() + myInt2.getInteger()));

                System.out.print("Thank you! To test again, press Enter.\n");
                inputLine = input.nextLine();
            } else
                System.out.print("I'm sorry, that is not a valid option. Please choose again.\n\n");
        }
    }
}

class MyInteger {
    //properties
    private int value;

    //constructor/accessor
    public MyInteger(int value) { this.value = value; }
    public int getInteger() { return this.value; }

    //comparing methods
    public boolean isPrime() { return MyInteger.isPrime(this.value); } //lazy but readable
    public boolean isOdd() { return !(this.value % 2 == 0); }
    public boolean isEven() { return this.value % 2 == 0; }
    public boolean equals(int value) { return this.value == value; }
    public boolean equals(MyInteger myInt) { return this.value == myInt.value; }

    //static methods
    public static boolean isPrime(int value) { //the 'main' isPrime method
        for (int i = 2; i < value; i++)
            if (value % i == 0)
                return false;
        return true;
    }
    public static boolean isOdd(int value) { return !(value % 2 == 0); }
    public static boolean isEven(int value) { return value % 2 == 0; }
    public static boolean isPrime(MyInteger myInt) { return MyInteger.isPrime(myInt.value); } //lazy but readable
    public static boolean isOdd(MyInteger myInt) { return !(myInt.value % 2 == 0); }
    public static boolean isEven(MyInteger myInt) { return myInt.value % 2 == 0; }
    public static int parseInt(char[] charArray) {
        StringBuilder intString = new StringBuilder();
        for (int i = 0; i < charArray.length; i++)
            if (Character.isDigit(charArray[i]))
                intString.append(charArray[i]);
        return Integer.parseInt(intString.toString());
    }
    public static int parseInt(String value) { //string to int via stringbuilder removing non-digits
        StringBuilder intString = new StringBuilder();
        for (int i = 0; i < value.length(); i++)
            if (Character.isDigit(value.charAt(i)))
                intString.append(value.charAt(i));
        return Integer.parseInt(intString.toString());
    }
}
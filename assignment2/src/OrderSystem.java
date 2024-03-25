/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 05 Nov 2022
 * 
 * This program creates classes for 2 types of snacks, and simulates an interface to order the snacks
 */

// import tools: scanner
import java.util.Scanner;

// create "main" class
public class OrderSystem {

    // create method: printMenu
    // this method will print the main menu options
    private void printMenu() {
        // params: none
        // user inputs: none
        // return value: none

        System.out.println("\tMENU");
        System.out.println("1. Order a Snack");
        System.out.println("2. Exit Program");
    }

    // create method: orderSnack
    // this method will show options for ordering snacks, and create an object based
    // on user inputs
    private void orderSnack() {
        // params: none
        // user inputs: selection of snack type (salty, fruit), size of snack (small
        // [S], med [M], or lg [L]), selection of add ons (nuts true/false, citrus
        // true/false)
        // return value: none

        // create method input scanner
        Scanner methodIn = new Scanner(System.in);

        // initialize size
        char size;

        // print options
        System.out.print("Do you want Fruit Snack (1) or Salty Snack (2): ");

        // gather snack type input
        int selection = methodIn.nextInt();

        switch (selection) {
            case 2: // salty snack
                System.out.print("What size do you want: S, M, or L: ");

                // gather size input
                size = methodIn.next().charAt(0);

                // option for nuts
                System.out.print("Do you want nut snack included? true/false: ");

                // gather nuts input
                boolean nuts = methodIn.nextBoolean();

                // create object using user coices
                SaltySnack salt = new SaltySnack(Character.toUpperCase(size), nuts);

                // display user order
                System.out.println(salt.toString());
                break;

            case 1: // fruit snack
                System.out.print("What size do you want: S, M, or L: ");

                // gather size input
                size = methodIn.next().charAt(0);

                // option for citrus
                System.out.print("Do you want citrus fruit included? true/false: ");

                // gather citrus input
                boolean citrus = methodIn.nextBoolean();

                // create object using user choices
                FruitSnack fruit = new FruitSnack(Character.toUpperCase(size), citrus);

                // display user order
                System.out.println(fruit.toString());
                break;

            default: // validation
                System.out.println("That is not one of out options");
        }
    }

    // main method
    // this method runs functionality to create snack objects
    public static void main(String[] args) {

        // main class instantiation
        OrderSystem enabler = new OrderSystem();

        // create scanner, standard input
        Scanner stdIn = new Scanner(System.in);

        // loop variable
        int select = 0;

        // do -> while to allow user to select functions
        // future proof code for additions that implement allowing multiple orders
        do {
            // call menu
            enabler.printMenu();
            System.out.print("Enter your selection:\t");

            // gather selection input
            select = stdIn.nextInt();

            // switch for selection
            switch (select) {

                case 1: // orders a snack
                    enabler.orderSnack();
                    System.out.println("Thank you for using the program!");

                    // since there are no arrays to store multiple objects, end program after 1
                    // order
                    select = 2;
                    break;

                case 2: // ends program
                    System.out.println("Thank you for using the program!");
                    break;

                default: // validation
                    System.out.println("That is not one of out options");

            }
        } while (select != 2);

        // close scanner
        stdIn.close();

    }
}
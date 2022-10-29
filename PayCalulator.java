/*****
 * PayCalulator.java
 * program to calculate weekly wages for nannying position
 * @author Julia Frances
 * @version 1.0
 *****/

import java.util.Scanner;
import java.util.ArrayList;
import PaycheckCalculatorClass.*;;

public class PayCalulator {
    public static void main(String args[]) {

        Scanner keyboard = new Scanner(System.in);

        // welcome message
        System.out.println("Welcome to your paycheck calculator. Congratulations on finishing another workweek! \nPlease provide the following information to calculate your week's wages.");

        // prompt user to input relevant paycheck information
        // each section here includes at least one while loop to validate user input, make sure excpetions are handled
        // each while loop breaks only when all exceptions are handled and the input is positive or 0
        int payPeriod = 0;
        while (true) { 
            try {
                System.out.println("What is your pay period? Input the number of weeks your paycheck covers: ");
                payPeriod = keyboard.nextInt();
                keyboard.nextLine();
                if (payPeriod >= 0) { // break loop only if input is positive
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            } 
        }

        double hourlyRate = 0;
        while (true) {
            try {
                System.out.println("Input your regular hourly rate: ");
                hourlyRate = keyboard.nextDouble();
                keyboard.nextLine();
                if (hourlyRate >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            }
        }

        double overnightRate = 0;
        while (true) {
            try {
                System.out.println("Input your overnight rate: ");
                overnightRate = keyboard.nextDouble();
                keyboard.nextLine();
                if (overnightRate >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            }
        }

        double extraChildRate = 0;
        while (true) {
            try {
                System.out.println("Input your dollarly rate per extra child: ");
                extraChildRate = keyboard.nextDouble();
                keyboard.nextLine();
                if (extraChildRate >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next(); 
                continue;
            }
        }

        double totalHours = 0;
        while (true) {
            try {
                System.out.println("Input your total regular weekly hours, not including overnights: ");
                totalHours = keyboard.nextDouble();
                keyboard.nextLine();
                if (totalHours >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            }
        }

        int overnights = 0;
        while (true) {
            try {
                System.out.println("Input number of overnights worked, if any: ");
                overnights = keyboard.nextInt();
                keyboard.nextLine();
                if (overnights >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            }
        }

        double extraChildHours = 0;
        int extraChildNum = 0;
        while (true) {
            try {
                System.out.println("Input number of hours worked with additional children, if any: ");
                extraChildHours = keyboard.nextDouble();
                keyboard.nextLine();
                if (extraChildHours >= 0) {
                    break;
                }
                System.out.println("Invalid input: positive number required.");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input: positive number required.");
                keyboard.next();
                continue;
            }
        }
        if (extraChildHours > 0) {
            while (true) {
                try {
                    System.out.println("Input number of additional children: ");
                    extraChildNum = keyboard.nextInt();
                    keyboard.nextLine();
                    if (extraChildNum >= 0) {
                        break;
                    }
                    System.out.println("Invalid input: positive number required.");
                    continue;
                } catch (Exception e) {
                    System.out.println("Invalid input: positive number required.");
                    keyboard.next();
                    continue;
                }
            }
        }

        // ask user if they are on the books or under the table 
        String paycheckString = null;
        System.out.println("Input '1' if you are paid on the books, OR input '2' if you are paid under the table: ");
        String answer = keyboard.next();
        // while loop to make sure user inputs one of the two options
        while (!answer.equalsIgnoreCase("1") && !answer.equalsIgnoreCase("2")) {
            System.out.println("Ivalid input. \nInput '1' if you are paid on the books, OR input '2' if you are paid under the table: ");
            answer = keyboard.nextLine();
            keyboard.nextLine();
        }
        // if user is on the books, while loop to find StateTaxRate enum and validate that user input is, indeed, a state
        if (answer.equalsIgnoreCase("1")) {
            StateTaxRate myState = null;
            while (true) {
                try { 
                    System.out.println("Input the two letter abbreviation for your work state: ");
                    String state = keyboard.next().toUpperCase();
                    keyboard.nextLine();
                    myState = StateTaxRate.valueOf(state);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input: state abbreviation does not exist.");
                    continue;
                }
            }
            // create TaxedPaycheck object with previous paycheck variables and found StateTaxRate
            TaxedPaycheck myPaycheck = new TaxedPaycheck(hourlyRate, overnightRate, extraChildRate, totalHours, overnights, extraChildHours, extraChildNum, myState);
            paycheckString = myPaycheck.toString(); // set paycheckString for later printing
        // if user is not on the books, create (untaxed) Paycheck object with previous paycheck variables
        } else if (answer.equalsIgnoreCase("2")) {
            Paycheck myPaycheck = new Paycheck(hourlyRate, overnightRate, extraChildRate, totalHours, overnights, extraChildHours, extraChildNum);
            paycheckString = myPaycheck.toString();
        }

        // ask user if they would like to report any reimbusements
        System.out.println("Do you have any reimbursements (expenses or stipends) to report? Input 'Y' if yes, or 'N' if no: ");
        String report = keyboard.next();
        // while loop to make sure user inputs one of the two options
        while (!report.equalsIgnoreCase("Y") && !report.equalsIgnoreCase("N")) {
            System.out.println("Ivalid input. \nDo you have any reimbursements (expenses or stipends) to report? Input 'Y' if yes, or 'N' if no: ");
            report = keyboard.nextLine();
            keyboard.nextLine();
        }
        // if they would like to report, create arrayList of reimbursement objects
        if (report.equalsIgnoreCase("Y")) {
            ArrayList<Reimbursement> myReimbursements = new ArrayList<Reimbursement>();
            String description;
            double cost;
            double amount;
            // while loop to add stipend and expense objects to arrayList
            String add = "NADA";
            while (!add.equalsIgnoreCase("DONE")) {
                System.out.println("To add a new reimbursement, enter 'ADD', or enter 'DONE' if done: ");
                add = keyboard.next();
                // if they are done adding objects, print final paycheckString, reimbursment arrayList, and total amount of reimbursments
                if (add.equalsIgnoreCase("DONE")) {
                    System.out.println();
                    System.out.println(paycheckString);
                    System.out.println();
                    System.out.println("Reimbursements \n=============");
                    // for loop to print reimbursement arrayList
                    for (Reimbursement c : myReimbursements) {
                    System.out.println(c.toString());
                    }
                    double totalCost = 0;
                    double totalAmount = 0;
                    // for loop to add up total amount owed for both expenses and stipends
                    for (Reimbursement r : myReimbursements) {
                        // if object is an expense, tally up cost
                        if (r instanceof Expense) {
                        Expense e = (Expense) r;
                        totalCost += e.getCost();
                        // if object is a stipend, tally up amount per this paycheck
                        } else if (r instanceof Stipend) {
                        Stipend s = (Stipend) r;
                        totalAmount += s.paycheckStipend();
                        }
                    }
                    System.out.println("============="); 
                    System.out.println("Total reimbursements owed this pay period: $" + (totalCost + totalAmount));
                // if they are not done, prompt user to provide information on reimbursement objects
                } else {
                    String type = "NADA";
                    System.out.println("Enter 'E' if you are adding an expense, or 'S' if you are adding a stipend: ");
                    type = keyboard.next();
                    // while loop to make sure user inputs one of the two options
                    while (!type.equalsIgnoreCase("E") && !type.equalsIgnoreCase("S")) {
                        System.out.println("Invalid input. \nEnter 'E' if you are adding an expense, or 'S' if you are adding a stipend: ");
                        type = keyboard.next();
                    }
                    // if object is an expense object
                    if (type.equalsIgnoreCase("E")) {
                        System.out.println("Enter a short description of the expense: ");
                        keyboard.nextLine();
                        description = keyboard.nextLine();
                        // while loop to make sure user inputs correctly
                        while (true) {
                            try {
                                System.out.println("Enter the cost of the expense: ");
                                cost = keyboard.nextDouble();
                                keyboard.nextLine();
                                if (cost >= 0) {
                                    break; // break loop only if cost is positive
                                }
                                System.out.println("Invalid input: positive number required.");
                                continue;
                            } catch (Exception e) {
                                System.out.println("Invalid input: positive number required.");
                                keyboard.next();
                                continue;
                            }
                        }
                        // add new expense object to reimbursement arrayList
                        myReimbursements.add(new Expense(description, cost));
                    // if object is a stipend object
                    } else if (type.equalsIgnoreCase("S")) {
                        System.out.println("Enter a short description of the stipend: ");
                        keyboard.nextLine();
                        description = keyboard.nextLine();
                        // while loop to make sure user inputs correctly
                        while (true) {
                            try {
                                System.out.println("Enter the monthly stipend amount: ");
                                amount = keyboard.nextDouble();
                                keyboard.nextLine();
                                if (amount >= 0) {
                                    break; // break loop only if amount is positive
                                }
                                System.out.println("Invalid input: positive number required.");
                                continue;
                            } catch (Exception e) {
                                System.out.println("Invalid input: positive number required.");
                                keyboard.next();
                                continue;
                            }
                        }
                        // add new stipend object to reimbursement arrayList
                        myReimbursements.add(new Stipend(description, amount, payPeriod));
                    }
                }
            }
        // if there are no reimbursements to report, print paycheckString 
        } else {
            System.out.println(paycheckString);
        }

        keyboard.close();

        // print reassuring goodbye message
        System.out.println("Your total pay for this pay period is calculated. Thank you for using me!");
        
    }
}
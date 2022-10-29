package PaycheckCalculatorClass;

/*****
 * ExpenseTeser.java
 * program to test the Expense class
 * @author Julia Frances
 * @version 1.0
 *****/

public class ExpenseTester {
    public static void main(String args[]){ 

        // create new object with the constructor
        Expense myExpense = new Expense("chick fil a", 23.09);

        // test and print getter
        System.out.println(myExpense.getCost());

        // test toString
        System.out.println(myExpense.toString());
    
    }
    
}

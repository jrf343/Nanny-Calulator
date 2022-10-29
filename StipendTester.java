package PaycheckCalculatorClass;

/*****
 * StipendTeser.java
 * program to test the Stipend class
 * @author Julia Frances
 * @version 1.0
 *****/

public class StipendTester {
    public static void main(String args[]){ 

        // create new object with the constructor
        Stipend myStipend = new Stipend("gas", 23.09, 2);

        // calculate and print portion of stipend owed for payperiod
        System.out.println(myStipend.paycheckStipend());

        // test toString
        System.out.println(myStipend.toString());
    
    }
    
}
package PaycheckCalculatorClass;

/*****
 * PaycheckTeser.java
 * program to test the Paycheck class
 * @author Julia Frances
 * @version 1.0
 *****/

public class PaycheckTester {
    public static void main(String args[]){ 

        // create new object with the constructor
        Paycheck myPaycheck = new Paycheck(30, 150, 2, 44, 1, 1, 2);

        // calculate and print base pay
        System.out.println(myPaycheck.basePay());

        // calculate and print overnight pay
        System.out.println(myPaycheck.overnightPay());

        // calculate and print extra child pay
        System.out.println(myPaycheck.extraChildPay());

        // calculate and print total money earned
        System.out.println(myPaycheck.untaxedCheck());

        // use toString
        System.out.println(myPaycheck.toString());
    }
    
}

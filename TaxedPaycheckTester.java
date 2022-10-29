package PaycheckCalculatorClass;

/*****
 * TaxedPaycheckTeser.java
 * program to test the TaxedPaycheck class
 * @author Julia Frances
 * @version 1.0
 *****/

public class TaxedPaycheckTester {
    public static void main(String args[]){ 

        // create new object with the constructor
        TaxedPaycheck myPaycheck = new TaxedPaycheck(30, 150, 2, 44, 1, 1, 2, StateTaxRate.PA);

        // test all superclass methods 
            // calculate and print base pay
            System.out.println(myPaycheck.basePay());

            // calculate and print overnight pay
            System.out.println(myPaycheck.overnightPay());

            // calculate and print extra child pay
            System.out.println(myPaycheck.extraChildPay());

            // calculate and print total money earned
            System.out.println(myPaycheck.untaxedCheck());

        // calculate and print state cut 
        System.out.println(myPaycheck.stateCut());

        // calculate and print fed cut
        System.out.println(myPaycheck.fedCut());

        // calculate and print total money earned, minus tax cuts 
        System.out.println(myPaycheck.taxedCheck());

        // test toString
        System.out.println(myPaycheck.toString());

    }
    
}

package PaycheckCalculatorClass;

/*****
 * Stipend.java
 * program to create a stipend class
 * @author Julia Frances
 * @version 1.0
 *****/

 /*****
  * UML 
  * Stipend
  -------------------
  * - amount : double
  * - payPeriod : int
  -------------------
  * + Stipend()
  * + paycheckStipend() : double
  * + toString() : String
  *****/

public class Stipend extends Reimbursement {
    private double amount;
    private int payPeriod;

    public Stipend(String description, double amount, int payPeriod) {
        super(description);
        this.amount = amount;
        this.payPeriod = payPeriod;
    }

    // method to return portion of monthly stipend owed this pay period
    public double paycheckStipend() {
        return amount / payPeriod;
    }

    public String toString() {
        return "Stipend description: " + description + " || Monthly stipend amount: $" + amount + " || Stipend mount per paycheck: $" + paycheckStipend();
    }
    
}

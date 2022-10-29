package PaycheckCalculatorClass;

/*****
 * Paycheck.java
 * program to create paycheck class
 * @author Julia Frances
 * @version 1.0
 *****/

/*****
  * UML 
  * Paycheck
  -------------------
  * # hourlyRate : double
  * # overnightRate : double
  * # extraChildRate : double
  * # totalHours : double
  * # overnights : int
  * # extraChildHours : double
  * # extraChildNum : int
  -------------------
  * + Paycheck()
  * + basePay() : double
  * + overnightPay() : double
  * + extraChildPay() : double
  * + untaxedCheck() : double
  * + toString() : String
  *****/

public class Paycheck {
    protected double hourlyRate;
    protected double overnightRate;
    protected double extraChildRate;
    protected double totalHours;
    protected int overnights;
    protected double extraChildHours;
    protected int extraChildNum;

    public Paycheck(double hourlyRate, double overnightRate, double extraChildRate, double totalHours, int overnights, double extraChildHours, int extraChildNum) {
        this.hourlyRate = hourlyRate;
        this.overnightRate = overnightRate;
        this.extraChildRate = extraChildRate;
        this.totalHours = totalHours;
        this.overnights = overnights;
        this.extraChildHours = extraChildHours;
        this.extraChildNum = extraChildNum;
    }

    public double basePay() {
        // calculate regular pay, get paid for 40 hours even if worked fewer than 40, subtract hours worked with additional children
        if (totalHours <= 40) {
            return (40 - extraChildHours) * hourlyRate;
        }
        // calculate regular pay including overtime hours over 40
        else {
            return ((40 - extraChildHours) * hourlyRate) + ((totalHours - 40) * (hourlyRate * 1.5));
        }
    }

    public double overnightPay() {
        if (overnights > 0) {
            return overnights * overnightRate;
        }
        else {
            return 0;
        }
    }

    public double extraChildPay() {
        if (extraChildHours > 0) {
            return extraChildHours * (extraChildRate + hourlyRate);
        }
        else {
            return 0;
        }
    }

    public double untaxedCheck() {
        return basePay() + overnightPay() + extraChildPay();
    }

    public String toString() {
        return "Untaxed Paycheck \n============= \nBase pay inlcuding overtime: $" + basePay() + "\nOvernight pay: $" + overnightPay() + "\nPay for extra children: $" + extraChildPay() + "\nTotal untaxed paycheck: $" + untaxedCheck();
    }
    
}

package PaycheckCalculatorClass;

/*****
 * TaxedPaycheck.java
 * program to create a taxed paycheck class
 * @author Julia Frances
 * @version 1.0
 *****/
 
 /*****
  * UML 
  * TaxedPaycheck
  -------------------
  * - fedTaxRate : double
  * - stateTax : StateTaxRate
  -------------------
  * + TaxedPaycheck()
  * + taxedCheck() : double
  * + stateCut() : double
  * + fedCut() : double
  * + toString() : String
  *****/

import java.text.*;

public class TaxedPaycheck extends Paycheck {
    private final double fedTax = 0.22;
    private StateTaxRate myState;

    public TaxedPaycheck(double hourlyRate, double overnightRate, double extraChildRate, double totalHours, int overnights, double extraChildHours, int extraChildNum, StateTaxRate myState) {
        super(hourlyRate, overnightRate, extraChildRate, totalHours, overnights, extraChildHours, extraChildNum);
        this.myState = myState;
    }
    
    // calculate the cut of paycheck taken by the state and rounded
    public double stateCut() {
        double stateCut = (untaxedCheck() - (untaxedCheck() * (1 - myState.findStateTax())));
        stateCut = (Math.round(stateCut * 100))/100.00;
        return stateCut;
    }

    // calculate the cut of paycheck taken by the federal government and rounded
    public double fedCut() {
        double fedCut = (untaxedCheck() - (untaxedCheck() * (1 - fedTax)));
        fedCut = (Math.round(fedCut * 100))/100.00;
        return fedCut;
    }

    // calculate total money earned, minus tax cuts and rounded
    public double taxedCheck() {
        double taxedCheck = basePay() + overnightPay() + extraChildPay() - stateCut() - fedCut();
        taxedCheck = (Math.round(taxedCheck * 100))/100.00;
        return taxedCheck;
    }

    public String toString() {
        NumberFormat percentFormat = NumberFormat.getPercentInstance(); // format state and federal tax rates as percentages
        String statePercentage = percentFormat.format(myState.findStateTax());
        String fedPercentage = percentFormat.format(fedTax);
        return "Taxed Paycheck \n============= \nBase pay inlcuding overtime: $" + basePay() + "\nOvernight pay: $" + overnightPay() + "\nPay for extra children: $" + extraChildPay() + "\nTotal untaxed paycheck: $" + untaxedCheck() + "\nState tax percentage, cut: " + statePercentage + ", $" + stateCut() + "\nFederal tax percentage, cut: " + fedPercentage + ", $" + fedCut() + "\nTotal taxed paycheck: $" + taxedCheck();


    }


}

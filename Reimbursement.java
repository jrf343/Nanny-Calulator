package PaycheckCalculatorClass;

/*****
 * Reimbursement.java
 * program to create abstract reimbursement class
 * @author Julia Frances
 * @version 1.0
 *****/

 /*****
  * UML 
  * Reimbursement
  -------------------
  * # description : String
  -------------------
  * + Reimbursement()
  * + toString() : String
  *****/

public abstract class Reimbursement { // abstract class to hold expense and stipend classes
    protected String description;

    public Reimbursement(String description) {
        this.description = description;
    }

    public abstract String toString();
    
}

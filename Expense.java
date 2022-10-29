package PaycheckCalculatorClass;

/*****
 * Expense.java
 * program to create expense class
 * @author Julia Frances
 * @version 1.0
 *****/

 /*****
  * UML 
  * Expense
  -------------------
  * - cost : Double
  -------------------
  * + Expense()
  * + getCost() : double
  * + toString() : String
  *****/

public class Expense extends Reimbursement {
    private double cost;

    public Expense(String description, Double cost) {
        super(description);
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String toString() {
        return "Expense description: " + description + " || Expense cost: $" + cost;
    }
    
}

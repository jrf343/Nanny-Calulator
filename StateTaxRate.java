package PaycheckCalculatorClass;

/*****
 * StateTaxRate.java
 * program to hold an enumerated list of state abbreviations and their income tax rates
 * @author Julia Frances
 * @version 1.0
 *****/

/*****
  * UML 
  * StateTaxRate <<ENUM>>
  -------------------
  * + stateTax : double
  -------------------
  * + StateTaxRate()
  * + findStateTax() : double
  *****/

public enum StateTaxRate {
    AL(0.05),
    AK(0.0),
    AZ(0.034),
    AR(0.055),
    CA(0.06),
    CO(0.045),
    CT(0.555),
    DE(0.022),
    FL(0.0),
    GA(0.0575),
    HI(0.079),
    ID(0.06),
    IL(0.0495),
    IN(0.0323),
    IA(0.0625),
    KS(0.057),
    KY(0.05),
    LA(0.0425),
    ME(0.0725),
    MD(0.0475),
    MA(0.05),
    MI(0.0435),
    MN(0.068),
    MS(0.05),
    MO(0.054),
    MT(0.0675),
    NE(0.0684),
    NV(0.0),
    NH(0.0),
    NJ(0.05525),
    NM(0.049),
    NY(0.0585),
    NC(0.0499),
    ND(0.0204),
    OH(0.03226),
    OK(0.0475),
    OR(0.0875),
    PA(0.0307),
    RI(0.0375),
    SC(0.07),
    SD(0.0),
    TN(0.0),
    TX(0.0),
    UT(0.0495),
    VT(0.0335),
    VA(0.0575),
    WA(0.0),
    WV(0.06),
    WI(0.053),
    WY(0.0),
    DC(0.065);

    public final double stateTax;

    StateTaxRate(double stateTax) {
        this.stateTax = stateTax;
    }

    // finder method to identify state tax 
    public double findStateTax() {
        return this.stateTax;
    }
    
}

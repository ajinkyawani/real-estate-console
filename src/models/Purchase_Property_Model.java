/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Purchase_Property_Model
DESCRIPTION: Model for purchase property class used to bind and transfer data.

 */

package models;

/**
 *
 * @author ajinkyawani
 */
public class Purchase_Property_Model {
    private double purchasePrize;
    private double annualTaxes;
    
    public Purchase_Property_Model() {
        this.purchasePrize = 0.0;
        this.annualTaxes = 0.0;
    }
    
    public Purchase_Property_Model(double purchasePrize, double annualTaxes) {
        this.purchasePrize = purchasePrize;
        this.annualTaxes = annualTaxes;
    }

    public double getPurchasePrize() {
        return purchasePrize;
    }

    public double getAnnualTaxes() {
        return annualTaxes;
    }

    public void setPurchasePrize(double purchasePrize) {
        this.purchasePrize = purchasePrize;
    }

    public void setAnnualTaxes(double annualTaxes) {
        this.annualTaxes = annualTaxes;
    }
    
    public String toString(){
    return this.getPurchasePrize()+ "\n" +
           this.getAnnualTaxes()+ "\n" ;
    }
    
}

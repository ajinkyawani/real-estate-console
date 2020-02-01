/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Condominium
DESCRIPTION: Condominium property class.

 */

package awani1_6617_hw2;

import Interfaces.ICondominium;

/**
 *
 * @author ajinkyawani
 */
public class Condominium extends Purchase_Property implements ICondominium{
    private double monthlyMaintenance;
    
    public Condominium() {}
    
    public Condominium (String address, String city, String state, int postalCode,
                        int numberOfBedrooms, int numberOfBathrooms, 
                        double purchasePrize, double annualTaxes, double monthlyMaintenance) {
        
        super(purchasePrize, annualTaxes, address, city, state, numberOfBedrooms,
                numberOfBedrooms, numberOfBathrooms);
        
        this.monthlyMaintenance = monthlyMaintenance;
    }

    public double getMonthlyMaintenance() {
        return monthlyMaintenance;
    }

    public void setMonthlyMaintenance(double monthlyMaintenance) {
        this.monthlyMaintenance = monthlyMaintenance;
    }
    
    public String toString() {
        return "\nCondominium Property\n" + super.toString() + "\n" +
                "Monthly Maintenance\t" + this.getMonthlyMaintenance();
    }
}

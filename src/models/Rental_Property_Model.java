/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Rental_Property_Model
DESCRIPTION: Model for rental property class used to bind and transfer data.

 */

package models;

/**
 *
 * @author ajinkyawani
 */
public class Rental_Property_Model {
    private double monthlyRent;
    private double leasePeriod;
    
    public Rental_Property_Model() {
        this.monthlyRent = 0.0;
        this.leasePeriod = 0.0;
    }
    
    public Rental_Property_Model(double monthlyRent, double leasePeriod) {
        this.monthlyRent = monthlyRent;
        this.leasePeriod = leasePeriod;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public double getLeasePeriod() {
        return leasePeriod;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setLeasePeriod(double leasePeriod) {
        this.leasePeriod = leasePeriod;
    }
    
}

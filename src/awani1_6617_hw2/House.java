/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: House
DESCRIPTION: House property class.

 */

package awani1_6617_hw2;

/**
 *
 * @author ajinkyawani
 */
public class House extends Purchase_Property {
    
    public House() {}
    
    public House(String address, String city, String state, int postalCode,
                int numberOfBedrooms, int numberOfBathrooms, double purchasePrize, 
                double annualTaxes){
        super(purchasePrize, annualTaxes, address, city, state, postalCode, 
                numberOfBedrooms, numberOfBathrooms);
    }
    
    public String toString(){
        return "\nHouse Property\n"  + super.toString();
    }
}

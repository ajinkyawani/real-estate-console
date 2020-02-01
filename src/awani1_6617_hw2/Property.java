/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Property
DESCRIPTION: Property class which is superclass of all other classes in the application.

 */

package awani1_6617_hw2;

import Interfaces.IProperty;

/**
 *
 * @author ajinkyawani
 */
public class Property implements IProperty{
    private String address;
    private String city;
    private String state;
    private int postalCode;
    private int numberOfBedrooms;
    private int numberOfBathrooms;

    public Property() {
    }
    
    public Property(String address, String city, String state, int postalCode,
            int numberOfBedrooms, int numberOfBathrooms) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
    }
    
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    @Override
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }    

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    @Override
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
    
    public String toString() {
        return "Street Address:\t" + this.getAddress() + "\n" +
                "City:\t" +this.getCity() + "\n" +
                "State:\t" + this.getState() + "\n" +
                "Postal Code:\t" +this.getPostalCode() + "\n" +
                "Number of Bedrooms:\t" + this.getNumberOfBedrooms()+ "\n" +
                "Number of Bathrooms:\t" + this.getNumberOfBathrooms();
    }
}

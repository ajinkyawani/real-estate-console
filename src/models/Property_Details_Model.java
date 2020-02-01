/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Property_Details_Model
DESCRIPTION: Model for property class used to bind and transfer data.

 */

package models;

/**
 *
 * @author ajinkyawani
 */
public class Property_Details_Model {
    private String address;
    private String city;
    private String state;
    private int postalCode;
    private int numberOfBedrooms;
    private int numberOfBathrooms;

    public Property_Details_Model() {}
    
    public Property_Details_Model(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String toString(){
    return this.getAddress() + "\n" +
           this.getCity() + "\n" +
           this.getState() + "\n" +
           this.getPostalCode()+ "\n" +
           this.getNumberOfBathrooms()+ "\n" +
           this.getNumberOfBedrooms()+ "\n" ;
    }
    
}

/*

CSCI 6617 S2 Fall 2019
Java Programming
Ajinkya Wani
awani1@unh.newhaven.edu
Instructor: Sheehan

NAME OF CLASS: Awani1_6617_HW2
DESCRIPTION: Rental Estate Application.

 */

package awani1_6617_hw2;

import Interfaces.IProperty;
import java.util.ArrayList;
import models.Property_Details_Model;
import models.Purchase_Property_Model;
import models.Rental_Property_Model;
import java.util.Scanner;

/**
 *
 * @author ajinkyawani
 */
public class Awani1_6617_HW2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isValid = false;
        boolean wrongExitChoice = false;
        boolean abortStatus = false;
        String value = "";
        Scanner input;
        int choice;
        String continueChoice = "";
        String exitChoice = "";
        Property_Details_Model propModel = new Property_Details_Model();
        Purchase_Property_Model purchaseProp = new Purchase_Property_Model();
        Rental_Property_Model rentalProp = new Rental_Property_Model();
        ArrayList<IProperty> propertyList = new ArrayList<IProperty>();
        
        System.out.println("Hello, Welcome to Real Estate Application");
        
        do {
            do {
                System.out.println("\nKindly Enter Your Choice."
                        + "\n1. Create house listing."
                        + "\n2. Create condominium listing."
                        + "\n3. Create Apartment listing."
                        + "\n4. Show listings."
                        + "\n5. Exit.");
                abortStatus = false;
                input = new Scanner(System.in);
                if (input.hasNextInt()){
                    isValid = true;
                    choice = input.nextInt();
                    switch(choice){
                        case 1: 
                            System.out.println("\nPlease note you can enter 'Abort' at any given time while entering property data "
                                    + "to return to the main menu.");
                            propModel = enterPropertyDetails();
                            if(propModel == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            purchaseProp = enterPurchasePropertyDetails();
                            if(purchaseProp == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            House house = new House(propModel.getAddress(), propModel.getCity(), propModel.getState(), 
                                    propModel.getPostalCode(), propModel.getNumberOfBedrooms(), propModel.getNumberOfBathrooms(), 
                                    purchaseProp.getPurchasePrize(), purchaseProp.getAnnualTaxes());
                            propertyList.add(house);
                            
                            System.out.println("\nYour property has been added!");
                            break;
                            
                        case 2:
                            System.out.println("\nPlease note you can enter 'Abort' at any given time while entering property data "
                                    + "to return to the main menu.");
                            propModel = enterPropertyDetails();
                            if(propModel == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            double monthlyMaintenance = 0.0;
                            purchaseProp = enterPurchasePropertyDetails();
                            if(purchaseProp == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            do {
                                System.out.println("\nEnter monthly maintenance of the property!");
                                input = new Scanner(System.in);

                                if (input.hasNextDouble()){
                                    isValid = true;
                                    monthlyMaintenance = input.nextDouble();
                                }
                                else if(input.hasNextLine()){
                                    value = input.nextLine();
                                    if(value.equals("Abort")){
                                        abortStatus = true;
                                        isValid = false;
                                        break;
                                    }
                                    else{
                                        System.out.println("Sorry, wrong input, please try again!");
                                        isValid = false;
                                    }
                                }
                                else {
                                    System.out.println("Sorry, wrong input, please try again!");
                                    isValid = false;
                                }
                            }while(!isValid);
                            
                            Condominium condo = new Condominium(propModel.getAddress(), propModel.getCity(), propModel.getState(), 
                                    propModel.getPostalCode(), propModel.getNumberOfBedrooms(), propModel.getNumberOfBathrooms(), 
                                    purchaseProp.getPurchasePrize(), purchaseProp.getAnnualTaxes(), monthlyMaintenance);
                            
                            if(!abortStatus){
                                propertyList.add(condo);
                                System.out.println("\nYour property has been added!");
                            }
                            break;
                            
                        case 3:
                            System.out.println("\nPlease note you can enter 'Abort' at any given time while entering property data "
                                    + "to return to the main menu.");
                            propModel = enterPropertyDetails();
                            if(propModel == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            rentalProp = enterRentalPropertyDetails();
                            if(rentalProp == null){
                                abortStatus = true;
                                isValid = false;
                                break;
                            }
                            
                            Apartment apartment = new Apartment(propModel.getAddress(), propModel.getCity(), propModel.getState(), 
                                    propModel.getPostalCode(), propModel.getNumberOfBedrooms(), propModel.getNumberOfBathrooms(), 
                                    rentalProp.getMonthlyRent(), rentalProp.getLeasePeriod());
                            propertyList.add(apartment);
                            System.out.println("\nYour Property has been added!");
                            break;
                            
                        case 4:
                            for(IProperty property: propertyList) {
                                System.out.println(property);
                                System.out.println("\n");
                            }
                            break;
                            
                        case 5:
                            do {
                                System.out.println("\nAre you sure you want to exit? Enter Y/N");
                                input = new Scanner(System.in);
                                if(input.hasNextLine()) {
                                   exitChoice = input.nextLine();
                                   switch(exitChoice){
                                       case "Y":
                                           System.out.println("\nThank you for using Real Estate Application, visit again!");
                                           System.exit(0);
                                       case "N":
                                           isValid = false;
                                           wrongExitChoice = true;
                                           break;
                                       default:
                                           System.out.println("Sorry, no such choice is available, try again!");
                                           isValid = false;
                                   }
                                   if(wrongExitChoice)
                                       break;
                                }
                                else{
                                    System.out.println("\nInvalid input, try again!");
                                    isValid = false;
                                }
                            }while(!isValid);
                            break;
                            
                        default:
                            System.out.println("Sorry, no such option is available!");
                    }
                    
                    if(!wrongExitChoice){
                    do{
                        if(abortStatus)
                            break;
                        System.out.println("\nDo you wish to continue? "
                                + "Enter Yes or No");
                        input = new Scanner(System.in);
                        if(input.hasNextLine()){
                            continueChoice = input.nextLine();
                            switch(continueChoice){
                                case "Yes":
                                     isValid = true;
                                    break;
                                case "No":
                                     System.exit(0);
                                default:
                                    isValid = false;
                                    System.out.println("You entered wrong choice, please try again!");
                                    break;
                            }
                        }
                    }while(!isValid);
                    }
                        
                }
                else {
                    System.out.println("Sorry, wrong input, please try again");
                    isValid = false;
                }
            
            } while (!isValid);
            
        }while(isValid);
    }
    
    private static Rental_Property_Model enterRentalPropertyDetails() {
        Scanner input;
        boolean isValid = false;
        String value = "";
        Rental_Property_Model rentalProp = new Rental_Property_Model();
        do {
            System.out.println("\nEnter monthly rent of the property!");
            input = new Scanner(System.in);

            if (input.hasNextDouble()){
                isValid = true;
                rentalProp.setMonthlyRent(input.nextDouble());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else {
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        
        do {
            System.out.println("\nEnter lease period of the property!");
            input = new Scanner(System.in);

            if (input.hasNextDouble()){
                isValid = true;
                rentalProp.setLeasePeriod(input.nextDouble());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else {
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        return rentalProp;
    }
    
    private static Purchase_Property_Model enterPurchasePropertyDetails() {
        Scanner input;
        boolean isValid = false;
        String value = "";
        Purchase_Property_Model purchaseProp = new Purchase_Property_Model();
        
        do {
            System.out.println("\nEnter purchase prize of the property!");
            input = new Scanner(System.in);

            if (input.hasNextDouble()){
                isValid = true;
                purchaseProp.setPurchasePrize(input.nextDouble());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else {
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter annual taxes of the property!");
            input = new Scanner(System.in);

            if (input.hasNextDouble()){
                isValid = true;
                purchaseProp.setAnnualTaxes(input.nextDouble());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else {
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        return purchaseProp;
    }
    
    private static Property_Details_Model enterPropertyDetails() {
        boolean isValid = false;
        Scanner input;
        Property_Details_Model propModel = new Property_Details_Model();
        String value = "";
        
        do {
            System.out.println("\nEnter address of the property!");
            input = new Scanner(System.in);

            if (input.hasNextLine()){
                isValid = true;
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else propModel.setAddress(value);
            }
            else {
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter city of the property!");
            input = new Scanner(System.in);
            
            if (input.hasNextLine()){
                isValid = true;
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                propModel.setCity(value);
            }
            else{
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter state of the property!");
            input = new Scanner(System.in);
            
            if (input.hasNextLine()){
                isValid = true;
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                propModel.setState(value);
            }
            else{
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter postalCode of the property!");
            input = new Scanner(System.in);
            
            if (input.hasNextInt()){
                isValid = true;
                propModel.setPostalCode(input.nextInt());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else{
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter number of bedrooms in the property!");
            input = new Scanner(System.in);
            
            if (input.hasNextInt()){
                isValid = true;
                propModel.setNumberOfBedrooms(input.nextInt());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else{
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
        
        do {
            System.out.println("\nEnter number of bathrooms in the property!");
            input = new Scanner(System.in);
            
            if (input.hasNextInt()){
                isValid = true;
                propModel.setNumberOfBathrooms(input.nextInt());
            }
            else if(input.hasNextLine()){
                value = input.nextLine();
                if(value.equals("Abort"))
                    return null;
                else{
                    System.out.println("Sorry, wrong input, please try again!");
                    isValid = false;
                }
            }
            else{
                System.out.println("Sorry, wrong input, please try again!");
                isValid = false;
            }
        }while(!isValid);
       
        return propModel;
    
    }
    
}

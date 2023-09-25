/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;
import model.Order;

/**
 *
 * @author DELL
 */
public class Library {
    // Kiem tra lua chon hop le tu nguoi dung
    public static int checkInputChoice(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max ) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch(NumberFormatException e) {
                System.out.format("Please, enter number in range %d - %d \n",min, max);
                System.out.print("Let's try enter again:        ");
            }
        }
    }
    
    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty() ) {
                System.out.println("Can not be empty. Try enter again:  "); 
            } else {
                return result;
            }
        }
    }
    
    public static boolean checkIdExist(ArrayList<Fruit> fruitList, String fruitId) {
        for (Fruit f : fruitList) {
            if (fruitId.equalsIgnoreCase(f.getFruitId()) ) {
                return false;
            }
        }
        return true;
    }
    
    public static double checkInputDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double choice = Double.parseDouble(sc.nextLine().trim());
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("*Invalid value(only type number). Try enter again:      ");
            }
        }
    }
    
    public static int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("*Invalid value(only type number). Try enter again:    ");
            }
        }
    }
    
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (y/n) ?       ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y") ) {
                return true;
            } else if (result.equalsIgnoreCase("N") ) {
                return false;
            }
            System.out.println("Please input y/Y or n/N. Try enter again:   ");
            
        }
    }
    
    public static boolean checkItemExist(ArrayList<Order> orderList, String fruitId) {
        for (Order order : orderList) {
            if (order.getFruitId().equalsIgnoreCase(fruitId)) {
                return false;
            }
        }
        return true;
    }
    
    
}

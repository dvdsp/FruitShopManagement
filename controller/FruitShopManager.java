/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;
import view.Menu;

/**
 *
 * @author DELL
 */
public class FruitShopManager extends Menu<String>  {
    static String[] mc = {"Create Fruit", "View orders", "Shopping (for buyer)", "exist"};
    private ArrayList<Fruit> fruitList ;
    private Hashtable<String, ArrayList<Order> > ht; 
    private Library validate;
    
    public FruitShopManager() {
        super("    FRUIT SHOP SYSTEM  ",mc);
        fruitList = new ArrayList<>();
        ht = new Hashtable<>();
        validate = new Library();
        fruitList.add(new Fruit("1", "Coconut", 4.123,10,"Vietnam"));
        fruitList.add(new Fruit("2", "Orange", 7,10,"US"));
        fruitList.add(new Fruit("3", "Apple", 8,10,"Thailand"));
    }
    
    
    
    @Override
    public void execute(int choice) {
       switch(choice) {
            case 1 -> createFruit();
            case 2 -> viewOrder();
            case 3 -> shopping();
            case 4 -> System.exit(0); 
       }
    }
    

    public void createFruit() {
        while (true) {
            System.out.print("Enter fruit id:         ");
            String fruitId = Library.checkInputString();
            if (!Library.checkIdExist(fruitList, fruitId)) {
                System.out.println("*Fruit Id already exist*");
                return;
            }
            
            System.out.print("Enter fruit name:         ");
            String fruitName = Library.checkInputString();
            System.out.print("Enter price:              ");
            double price = Library.checkInputDouble();
            System.out.print("Enter quantity:           ");
            int quantity = Library.checkInputInt();
            System.out.print("Enter origin:             ");
            String origin = Library.checkInputString();
            // 
            fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            System.out.println("* Add fruit item successful\n");
            if (!Library.checkInputYN()) {
                return;
            }
        }
    }

    // user view order
    public void viewOrder() {
        for (String name : ht.keySet()) {
            System.out.println("Customer:   " + name);
            ArrayList<Order> orderList = ht.get(name);
            displayOrderList(orderList);
        }
    }
    
    public void displayOrderList(ArrayList<Order> orderList) {
        double total = 0;
        System.out.format("%7s   | %8s    | %5s    | %6s\n",
                            "Product", "Quantity" , "Price", "Amount");
        for (Order order : orderList) {
            System.out.format("%5s    %6d    %10.3f$%10.3f$\n", 
            order.getFruitName(), order.getQuantity(), order.getPrice(),  order.getPrice() * order.getQuantity() );
        
            total = total + order.getPrice() * order.getQuantity();
        }
        System.out.format("* Total product value:    %.3f$ \n", total  );
    }

    
    public void shopping() {
        if (fruitList.isEmpty()) {
            System.out.println("*Oops..There is no item*");
            return ;
        }
        
        ArrayList<Order> orderList = new ArrayList<>();
        while (true) {
            displayFruitList();
            System.out.println("----------------------------");
            System.out.print("Enter the category of orders:     ");
            int item = Library.checkInputChoice(1, fruitList.size());
            
            Fruit fruit = getFruitByItem(item);
            
            System.out.print("Enter the number of items:     ");
            int quantity = Library.checkInputChoice(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            
            // check item exist or not
            if (!Library.checkItemExist(orderList, fruit.getFruitId())) {
                updateOrder(orderList, fruit.getFruitId(), quantity);
            } else {
                orderList.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }
            
            if (!Library.checkInputYN()) {
                break ;
            }    
        }
        // hien thi danh muc don hang ma khach da chon
        displayOrderList(orderList);
        System.out.print("The name of the orderer:    ");
        String name = Library.checkInputString();
        ht.put(name, orderList);
        System.out.println("*Add item successfull !");
    }
    
    public void displayFruitList() {
        System.out.format("|| ==%-4s== || ==%-10s== || ==%-6s== || ==%-5s== ||\n", 
                                "Item", "Fruit Name", "Origin", "Price");
        int countItem = 1;
        for (Fruit fruit :fruitList) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("      %-10d %-15s  %-15s%-5.3f($)\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());  
            }
        }
    }
    public  Fruit getFruitByItem(int item) {
        int countItem = 1;
        for (Fruit fruit : fruitList) {
            // check shop have item or not
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    // if order exist then update order
    public void updateOrder(ArrayList<Order> orderList, String fruitId, int quantity) {
        for (Order order : orderList) {
            if (order.getFruitId().equalsIgnoreCase(fruitId) ) {
                
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    

}

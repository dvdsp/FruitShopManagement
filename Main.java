
//import common.Validate;
import controller.FruitShopManager;
//import java.util.ArrayList;
//import java.util.Hashtable;
//import model.Fruit;
//import model.Order;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        FruitShopManager manage = new FruitShopManager();
        manage.run();
//        ArrayList<Fruit> fruitList = new ArrayList<>();
//        Hashtable<String, ArrayList<Order> > ht = new Hashtable<>();
//        
//        fruitList.add(new Fruit("1", "Coconut", 2.123,10,"Vietnam"));
//        fruitList.add(new Fruit("2", "Orange", 3,10,"US"));
//        fruitList.add(new Fruit("3", "Apple", 4,10,"Thailand"));
//        
//        while (true) {
//            FruitShopManager.menu();
//            int choice = Validate.checkInputChoice(1,4);
//            switch (choice) {
//                case 1: FruitShopManager.createFruit(fruitList);    break;
//                case 2: FruitShopManager.viewOrder(ht);             break;
//                case 3: FruitShopManager.shopping(fruitList, ht);   break;
//                case 4: 
//                    System.exit(0);
//                    
//            }
//        }
    }
}

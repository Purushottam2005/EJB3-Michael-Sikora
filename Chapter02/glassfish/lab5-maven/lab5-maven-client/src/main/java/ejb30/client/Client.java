package ejb30.client;

import java.util.*;
import javax.naming.*;
import ejb30.session.*;
import javax.ejb.EJB;

public class Client {
    
    @EJB
    private static ShoppingCart shoppingCart; 
    @EJB
    private static ShoppingCart shoppingCart2; 
    @EJB
    private static ShoppingCart shoppingCart3; 
    @EJB
    private static ShoppingCart shoppingCart4; 
    @EJB
    private static ShoppingCart shoppingCart5; 
    @EJB
    private static ShoppingCart shoppingCart6; 
    
    public static void main(String args[]) throws Exception {
 
       shoppingCart.addItem("Bread");
       shoppingCart.addItem("Milk");
       Thread.sleep(15000);
       shoppingCart.addItem("Tea");

       System.out.println("Contents of your cart are:");
       Collection<String> items = shoppingCart.getItems();
       for (String item : items) {
            System.out.println(item);
       }

       shoppingCart.finished();
    }

}



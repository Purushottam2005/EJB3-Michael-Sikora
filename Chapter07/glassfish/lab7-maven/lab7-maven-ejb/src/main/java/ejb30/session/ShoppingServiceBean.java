package ejb30.session;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import java.util.*;
import ejb30.session.ShoppingCartException;

@Stateful
public class ShoppingServiceBean implements ShoppingService {
    
  private @EJB ShoppingCart shoppingCart;
  private Collection<String> items;
 
   public void doShopping() throws ShoppingCartException {
       shoppingCart.addItem("Bread");
       shoppingCart.addItem("Milk");
       shoppingCart.addItem("Tea");
   
     //  throw new ShoppingCartException();  //Simulating application exception
    }
  
 

    public Collection<String> getItems() {
        return shoppingCart.getItems();
    }

}



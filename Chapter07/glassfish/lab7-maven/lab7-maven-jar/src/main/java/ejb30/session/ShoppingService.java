package ejb30.session;
import javax.ejb.Remote;
import java.util.*;


@Remote
public interface ShoppingService {
    void doShopping() throws ShoppingCartException ;
    Collection<String> getItems(); 
}

   
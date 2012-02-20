package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.ejb.EJBException;

@Stateless
public class BankServiceBean implements BankService {
   
   private @EJB AuditService audit;

   @PersistenceContext(unitName="BankService")  
   private EntityManager em; 

    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }

    public void addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
  
        try {
             audit.addAuditMessage(1, "customer add attempt"); 
        } catch (EJBException e) {
             System.out.println("Exception auditing customer");
        }
    }


    public void persistCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
    }


}



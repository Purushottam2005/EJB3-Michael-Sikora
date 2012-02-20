package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Referee;
import ejb30.entity.Account;
import ejb30.entity.Address;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.*; 
 
@Stateless
public class BankServiceBean implements BankService {
   
   
   @PersistenceContext(unitName="BankService") 
   private EntityManager em;

    public void createCustomers() {
       
       Referee r1 = new Referee();
       r1.setId(1);
       r1.setName("SIR JOHN DEED");
       r1.setComments("JUDGE");
       em.persist(r1);

       Customer c1 = new Customer();
       c1.setId(1);
       c1.setFirstName("SIMON");
       c1.setLastName("KING");
       c1.setReferee(r1); 
       
       Account a1 = new Account();
       a1.setId(1);
       a1.setBalance(430.5);
       a1.setAccountType("C");
       ArrayList<Account> accounts1 = new ArrayList<Account>();
       accounts1.add(a1);
       c1.setAccounts(accounts1);
   //    em.persist(a1);
       
       Address add1 = new Address();
       add1.setId(1);
       add1.setAddressLine("49, KINGS ROAD MANCHESTER");
       add1.setCountry("UK");
       add1.setPostCode("MN1 2AB");
       ArrayList<Address> addresses1 = new ArrayList<Address>();
       addresses1.add(add1);
       c1.setAddresses(addresses1);
       em.persist(add1);
       em.persist(c1);

       Referee r2 = new Referee();
       r2.setId(2);
       r2.setName("DR WILLIAM SMITH");
       r2.setComments("MEDICAL PRACTIONER");
       em.persist(r2);

       Customer c2 = new Customer();
       c2.setId(2);
       c2.setFirstName("JANE");
       c2.setLastName("KING");
       c2.setReferee(r2); 

       Account a2 = new Account();
       a2.setId(2);
       a2.setBalance(99);
       a2.setAccountType("C");
       ArrayList<Account> accounts2 = new ArrayList<Account>();
       accounts2.add(a2);
       c2.setAccounts(accounts2);
  //     em.persist(a2); 
       
       c2.setAddresses(addresses1); // same address as John King
       em.persist(c2);

       Referee r3 = new Referee();
       r3.setId(3);
       r3.setName("MICHAEL ELLIS");
       r3.setComments("MAJOR SHAREHOLDER OF THIS BANK");
       em.persist(r3);

       Customer c3 = new Customer();
       c3.setId(3);
       c3.setFirstName("JAMES");
       c3.setLastName("PAGE");
       c3.setReferee(r3); 

       Account a3 = new Account();
       a3.setId(3);
       a3.setBalance(123.65);
       a3.setAccountType("C");
       ArrayList<Account> accounts3 = new ArrayList<Account>();
       accounts3.add(a3);
       c3.setAccounts(accounts3);
  //     em.persist(a3);
 
       Address add2 = new Address();
       add2.setId(2);
       add2.setAddressLine("FLAT 10, QUEENS COURT, THAMES STREET, ROCHESTER");
       add2.setCountry("UK");
       add2.setPostCode("RC3 9XY");

       Address add3 = new Address();
       add3.setId(3);
       add3.setAddressLine("THE GRANGE, HILL RISE, BOXLEY, KENT");
       add3.setCountry("UK");
       add3.setPostCode("MD9 1BX");

       ArrayList<Address> addresses2 = new ArrayList<Address>();
       addresses2.add(add2);
       addresses2.add(add3); // James Page has 2 addresses
       c3.setAddresses(addresses2);
       em.persist(add2);
       em.persist(add3);
       em.persist(c3);

       Referee r4 = new Referee();
       r4.setId(4);
       r4.setName("RICHARD BRANSON");
       r4.setComments("HE SHOULD BANK WITH US");
       em.persist(r4);

       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
       c4.setReferee(r4);   

       Account a4 = new Account();
       a4.setId(4);
       a4.setBalance(23);
       a4.setAccountType("C");
       Account a5 = new Account();
       a5.setId(5);
       a5.setBalance(5200);
       a5.setAccountType("S");
       ArrayList<Account> accounts4 = new ArrayList<Account>();
       accounts4.add(a4);
       accounts4.add(a5);  // Edward Cook has 2 accounts
       c4.setAccounts(accounts4);
 //      em.persist(a4);
 //      em.persist(a5);
       
       Address add4 = new Address();
       add4.setId(4);
       add4.setAddressLine("2 HIGH STREET, HORSHAM");
       add4.setCountry("UK");
       add4.setPostCode("2HO 1RU");
       ArrayList<Address> addresses4 = new ArrayList<Address>();
       addresses4.add(add4);
       c4.setAddresses(addresses4);
       em.persist(add4);
       em.persist(c4);  
    }
    
    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }

    public List<Account> findAllAccounts() { 
        return (List<Account>)em.createQuery("SELECT ac FROM Account ac").getResultList();
    }

    public void updateCustomer(Customer cust) {
        Customer mergedCust = em.merge(cust);
        em.persist(mergedCust);
        em.flush(); 
    }

    public void removeCustomer(Customer cust) { 
        Customer mergedCust = em.merge(cust);
        em.remove(mergedCust);
    }

    public void refreshCustomer(Customer cust) {
         Customer mergedCust = em.merge(cust);
         mergedCust.setFirstName("Larry");
         System.out.println("before refresh:" + mergedCust);
         em.refresh(mergedCust);
         System.out.println("after refresh:" + mergedCust);
    }
    
}

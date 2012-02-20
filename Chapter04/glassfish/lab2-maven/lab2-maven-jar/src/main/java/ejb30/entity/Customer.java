package ejb30.entity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import static javax.persistence.FetchType.*;

@Entity
public class Customer implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Referee referee;
    private Collection<Address> addresses;
    private Collection<Account> accounts;

    public Customer() {}

    @Id
    @Column(name="CUSTOMER_ID")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column(name="FIRST_NAME", length=30)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column(name="LAST_NAME", length=30) 
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @OneToOne
    public Referee getReferee() { return referee; }
    public void setReferee(Referee referee) { this.referee = referee; }
    
    @OneToMany(mappedBy="customer", fetch=EAGER)
    public Collection<Account> getAccounts() { return accounts; }
    public void setAccounts(Collection<Account> accounts) { this.accounts = accounts; }
       
    @ManyToMany(fetch=EAGER) 
    @JoinTable(
        name="CUSTOMER_ADDRESS",
        joinColumns=@JoinColumn(name="CUST_ID", referencedColumnName="CUSTOMER_ID"),
        inverseJoinColumns=@JoinColumn(name="ADD_ID", referencedColumnName="ADDRESS_ID")
    )  
    public Collection<Address> getAddresses() { return addresses; }
    public void setAddresses(Collection<Address> addresses) { this.addresses = addresses; }
    
    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + ", referee=" + referee + ",addresses=" + addresses
              + ",accounts=" + accounts + "]";
   }
}


 

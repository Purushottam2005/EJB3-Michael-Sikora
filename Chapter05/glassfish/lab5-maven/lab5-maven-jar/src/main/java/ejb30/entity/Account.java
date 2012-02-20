package ejb30.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@NamedQueries({
@NamedQuery(name="findCheckingAccounts",
            query="SELECT a FROM Account a WHERE a.balance > :firstString AND a.accountType = 'C' "),
@NamedQuery(name="findSavingsAccounts",
           query="SELECT a FROM Account a WHERE a.balance > :firstString AND a.accountType = 'S' ")

})


@Entity
public class Account implements Serializable {
    private int id;
    private double balance;
    private String accountType;
    private Customer customer;

    public Account() {}

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public double getBalance() {
       return balance;
    }

    public void setBalance(double balance) {
       this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
       this.accountType = accountType;
    }

    @ManyToOne 
    @JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID") 
    public Customer getCustomer() {
       return customer;
    }

    public void setCustomer(Customer customer) {
       this.customer = customer;
    }


    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
             + ",account type=" + accountType + "]";
    }
}

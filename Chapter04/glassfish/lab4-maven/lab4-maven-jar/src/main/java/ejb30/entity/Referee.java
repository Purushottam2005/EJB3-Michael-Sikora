package ejb30.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Referee implements Serializable {
     private int id;
     private String name;
     private String comments;
     private Customer customer;

     public Referee() {
     }

     @Id
     @Column(name="REF_ID") 
     public int getId() {
        return id;
     }

     public void setId(int id) {
        this.id = id;
     }

     @Column(name="NAME", length=30) 
     public String getName() {
        return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     @Column(name="COMMENTS", length=40) 
     public String getComments() {
        return comments;
     }

     public void setComments(String comments) {
         this.comments = comments;
     }

 
     public String toString() {
        return "[referee id=" + id + ",name=" + name + ",comments=" + comments + "]";
    }

} 


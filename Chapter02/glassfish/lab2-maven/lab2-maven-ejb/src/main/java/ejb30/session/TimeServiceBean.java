package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;

@Stateless
public class TimeServiceBean implements TimeService {
   private int cnt=0;
   public String getTime() { 
     Formatter fmt = new Formatter();
     Calendar cal = Calendar.getInstance();
     fmt.format("%tr", cal);
     cnt++;
     return "lab2:"+fmt.toString();   
  } 
  public int getCnt() { 
    return cnt;
  }
} 


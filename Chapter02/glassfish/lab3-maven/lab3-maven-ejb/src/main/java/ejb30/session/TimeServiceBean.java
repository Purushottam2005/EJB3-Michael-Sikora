package ejb30.session;
import java.util.*; 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class TimeServiceBean implements TimeService {
    
   @Resource private SessionContext ctx;
   @PostConstruct
   public void init() { System.out.println("Post Constructor Method init() Invoked"); }
    
   public String getTime() { 
     Formatter fmt = new Formatter();
     Calendar cal = Calendar.getInstance();
     fmt.format("%tr", cal);
     return "lab3:"+ ctx.getInvokedBusinessInterface()+":"+fmt.toString();
     //remember to add logging
  } 
  
 @PreDestroy
   public void tidyUp() { System.out.println("Pre Destruction Method tidyUp() Invoked"); }
  
} 


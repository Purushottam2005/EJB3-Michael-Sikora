package ejb30.client;

import ejb30.session.*;
import javax.naming.*;


public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       InitialContext ctx = new InitialContext();
       TimeService timeService = (TimeService) ctx.lookup("ejb30.session.TimeService");
       String time = timeService.getTime();
       System.out.println("Time is: " + time);
    }
}


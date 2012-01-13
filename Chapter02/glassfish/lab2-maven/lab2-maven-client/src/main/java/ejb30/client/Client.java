package ejb30.client;

import ejb30.session.TimeService;
import javax.ejb.EJB;

public class Client {

    @EJB
    private static TimeService timeServiveBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("finalmente ahora es "+timeServiveBean.getTime());
        System.out.println("Cnt is: " + timeServiveBean.getCnt());
    }
}


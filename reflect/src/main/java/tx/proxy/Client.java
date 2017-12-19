package tx.proxy;

public class Client {

    public static void main(String[] args) {

        HireHouse hh = new HireHouseProxy(new HireHouseImpl());
        hh.hire();

        HireHouse hh1 = new HireHouseImpl();
        hh1.hire();
    }
}

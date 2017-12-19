package tx.proxy;

public class HireHouseProxy implements HireHouse {

    // 真是角色
    private HireHouse hh;

    public HireHouseProxy(HireHouse hh) {
        this.hh = hh;
    }

    @Override
    public void hire() {
        System.out.println("收中介费");
        hh.hire();
        System.out.println("扣押金");
    }
}

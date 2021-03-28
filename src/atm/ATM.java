package atm;

public class ATM {

    private long atmId;
    private String name;
    private String address;
    private double totalMoney;

    public ATM(String name, String address, double totalMoney) {
        this.name = name;
        this.address = address;
        this.totalMoney = totalMoney;
    }

    public ATM(long atmId, String name, String address, double totalMoney) {
        this.atmId = atmId;
        this.name = name;
        this.address = address;
        this.totalMoney = totalMoney;
    }

    public long getAtmId() {
        return atmId;
    }

    public void setAtmId(long atmId) {
        this.atmId = atmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}

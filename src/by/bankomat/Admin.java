package by.bankomat;

/**
 * Created by USER on 26.01.2018.
 */
public class Admin {
    private int passwordForAdmin;
    private int cashOfAdmin;
    private int fiveTypeOfMoney;
    private int tenTypeOfMoney;
    private int twentyTypeOfMoney;
    private int fiftyTypeOfMoney;
    Bankomat bankomat;

    public Admin(int  fiveTypeOfMoney, int  tenTypeOfMoney, int  twentyTypeOfMoney, int fiftyTypeOfMoney){
        this.fiveTypeOfMoney=fiveTypeOfMoney;
        this.tenTypeOfMoney=tenTypeOfMoney;
        this.twentyTypeOfMoney=twentyTypeOfMoney;
        this.fiftyTypeOfMoney=fiftyTypeOfMoney;
        this.cashOfAdmin = cashOfAdmin();
    }

    public void setPasswordForAdmin(int passwordForAdmin) {
        this.passwordForAdmin = passwordForAdmin;
    }

    public int cashOfAdmin() {
        this.cashOfAdmin=fiveTypeOfMoney*5 + tenTypeOfMoney*10+ twentyTypeOfMoney*20+ fiftyTypeOfMoney*50;
        return cashOfAdmin;
    }

    public void setCashOfAdmin(int cashOfAdmin) {
        this.cashOfAdmin = cashOfAdmin;
    }

    public int getFiveTypeOfMoney() {
        return fiveTypeOfMoney;
    }

    public void setFiveTypeOfMoney(int fiveTypeOfMoney) {
        this.fiveTypeOfMoney = fiveTypeOfMoney;
    }

    public int getTenTypeOfMoney() {
        return tenTypeOfMoney;
    }

    public void setTenTypeOfMoney(int tenTypeOfMoney) {
        this.tenTypeOfMoney = tenTypeOfMoney;
    }

    public int getTwentyTypeOfMoney() {
        return twentyTypeOfMoney;
    }

    public void setTwentyTypeOfMoney(int twentyTypeOfMoney) {
        this.twentyTypeOfMoney = twentyTypeOfMoney;
    }

    public int getFiftyTypeOfMoney() {
        return fiftyTypeOfMoney;
    }

    public void setFiftyTypeOfMoney(int fiftyTypeOfMoney) {
        this.fiftyTypeOfMoney = fiftyTypeOfMoney;
    }

    public int getPasswordForAdmin() {

        return passwordForAdmin;

    }

    public int getCashOfAdmin() {
        return cashOfAdmin;
    }

    public void getQuantityAdminTypeOfMoney(Admin admin){
        System.out.println("----------------------------------------------");
        System.out.println("Количесвто разных типов денег админа");
        System.out.println("Количесвто купюр 5 типа = " + admin.fiveTypeOfMoney);
        System.out.println("Количесвто купюр 10 типа = " + admin.tenTypeOfMoney);
        System.out.println("Колличество купюр 20 типа = " + admin.twentyTypeOfMoney);
        System.out.println("Колличество купюр 50 типа = " + admin.fiftyTypeOfMoney);
        System.out.println("----------------------------------------------");
    }


}

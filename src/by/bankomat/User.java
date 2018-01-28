package by.bankomat;

/**
 * Created by USER on 26.01.2018.
 */
public class User {
    private int fiveTypeOfMoney;
    private int tenTypeOfMoney;
    private int twentyTypeOfMoney;
    private int fiftyTypeOfMoney;
    private int balanceOfUser;
    private int cashOfUser;
    Bankomat bankomat;

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

    public int getBalanceOfUser() {
        return balanceOfUser;
    }



    public void setBalanceOfUser(int balanceOfUser) {
        this.balanceOfUser = balanceOfUser;
    }

    public User(){
    }

    public User(int fiveTypeOfMoney,int tenTypeOfMoney, int twentyTypeOfMoney, int fiftyTypeOfMoney, int balanceOfUser){
        this.fiveTypeOfMoney = fiveTypeOfMoney;
        this.tenTypeOfMoney = tenTypeOfMoney;
        this.twentyTypeOfMoney = twentyTypeOfMoney;
        this.fiftyTypeOfMoney = fiftyTypeOfMoney;
        this.cashOfUser= cashOfUser();
        this.balanceOfUser = balanceOfUser;
    }
    public int cashOfUser() {
        this.cashOfUser=fiveTypeOfMoney*5 + tenTypeOfMoney*10+ twentyTypeOfMoney*20+ fiftyTypeOfMoney*50;
        return cashOfUser;
    }
}
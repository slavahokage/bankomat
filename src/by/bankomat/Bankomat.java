package by.bankomat;

/**
 * Created by USER on 26.01.2018.
 */
public class Bankomat {
    private String nameOfBankomat;
    private int maxSizeOfMoney;
    private int fiveTypeOfMoney;
    private int tenTypeOfMoney;
    private int twentyTypeOfMoney;
    private int fiftyTypeOfMoney;
    private int balanceOfBankomat;
    private int passwordForAdmin;
    Admin admin;
    User user;

    public Bankomat() {
    }

    public Bankomat(String nameOfBankomat, int maxSizeOfMoney, int fiveTypeOfMoney, int tenTypeOfMoney, int twentyTypeOfMoney, int fiftyTypeOfMoney, int passwordForAdmin, Admin admin) {
        admin.setPasswordForAdmin(passwordForAdmin);
        this.nameOfBankomat = nameOfBankomat;
        this.maxSizeOfMoney = maxSizeOfMoney;
        this.fiveTypeOfMoney = fiveTypeOfMoney;
        this.tenTypeOfMoney = tenTypeOfMoney;
        this.twentyTypeOfMoney = twentyTypeOfMoney;
        this.fiftyTypeOfMoney = fiftyTypeOfMoney;
        this.balanceOfBankomat = balanceOfBankomat();
        this.passwordForAdmin = passwordForAdmin;

    }
    public Bankomat(String nameOfBankomat, int maxSizeOfMoney, int fiveTypeOfMoney, int tenTypeOfMoney, int twentyTypeOfMoney, int fiftyTypeOfMoney) {
        this.nameOfBankomat = nameOfBankomat;
        this.maxSizeOfMoney = maxSizeOfMoney;
        this.fiveTypeOfMoney = fiveTypeOfMoney;
        this.tenTypeOfMoney = tenTypeOfMoney;
        this.twentyTypeOfMoney = twentyTypeOfMoney;
        this.fiftyTypeOfMoney = fiftyTypeOfMoney;
        this.balanceOfBankomat = balanceOfBankomat();
    }


    private int balanceOfBankomat(Bankomat bankomat) {
        int balanceForReturn = bankomat.fiveTypeOfMoney * 5 + bankomat.tenTypeOfMoney * 10 + bankomat.twentyTypeOfMoney * 20 + bankomat.fiftyTypeOfMoney * 50;
        return balanceForReturn;
    }
    private int balanceOfBankomat() {
        int balanceForReturn = fiveTypeOfMoney * 5 + tenTypeOfMoney * 10 + twentyTypeOfMoney * 20 + fiftyTypeOfMoney * 50;
        return balanceForReturn;
    }

    public void getQuantityTypeOfMoney(int typeOfMoney, int passwordForAdmin) {
        if (this.passwordForAdmin != passwordForAdmin) {
            System.out.println("Отказ в доступе");
        } else {
            switch (typeOfMoney) {
                case 5:
                    System.out.println("----------------------------------------------");
                    System.out.println("Количесвто купюр данного типа = " + fiveTypeOfMoney);
                    System.out.println("----------------------------------------------");
                    break;
                case 10:
                    System.out.println("----------------------------------------------");
                    System.out.println("Количесвто купюр данного типа = " + tenTypeOfMoney);
                    System.out.println("----------------------------------------------");
                    break;
                case 20:
                    System.out.println("----------------------------------------------");
                    System.out.println("Колличество купюр данного типа = " + twentyTypeOfMoney);
                    System.out.println("----------------------------------------------");
                    break;
                case 50:
                    System.out.println("----------------------------------------------");
                    System.out.println("Колличество купюр данного типа = " + fiftyTypeOfMoney);
                    System.out.println("----------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------");
                    System.out.println("К сожалению данного типа денег нет");
                    System.out.println("----------------------------------------------");
                    break;
            }
        }
    }

    public void findOutTheAmountOfMoneyOnTheCard(User user){
        System.out.println("----------------------------------------------");
        System.out.println("Баланс на карточке = "+user.getBalanceOfUser());
        System.out.println("----------------------------------------------");
    }

    public void getAllQuantityTypeOfMoney(int passwordForAdmin,Bankomat bankomat) {
        System.out.println("----------------------------------------------");
        System.out.println("Количесвто разных типов денег в банкомате");
        System.out.println("Количесвто купюр 5 типа = " + bankomat.fiveTypeOfMoney);
        System.out.println("Количесвто купюр 10 типа = " + bankomat.tenTypeOfMoney);
        System.out.println("Колличество купюр 20 типа = " + bankomat.twentyTypeOfMoney);
        System.out.println("Колличество купюр 50 типа = " + bankomat.fiftyTypeOfMoney);
        System.out.println("----------------------------------------------");
    }

    public void checkBalanceByAdmin(int passwordForAdmin,Bankomat bankomat) {
        if (this.passwordForAdmin == passwordForAdmin) {
            System.out.println("----------------------------------------------");
            System.out.println("Балланс банкомата = " + balanceOfBankomat(bankomat));
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("В доступе отказано");
            System.out.println("----------------------------------------------");
        }

    }

    public void getQuantityUserTypeOfMoney(User user){
        System.out.println("----------------------------------------------");
        System.out.println("Количесвто разных типов денег юзера");
        System.out.println("Количесвто купюр 5 типа = " + user.getFiveTypeOfMoney());
        System.out.println("Количесвто купюр 10 типа = " + user.getTenTypeOfMoney());
        System.out.println("Колличество купюр 20 типа = " + user.getTwentyTypeOfMoney());
        System.out.println("Колличество купюр 50 типа = " + user.getTwentyTypeOfMoney());
        System.out.println("----------------------------------------------");
    }

    public void replenishAccountBalanceOfBankomat(Admin admin, int quantity,Bankomat bankomat) {
        if (this.passwordForAdmin != admin.getPasswordForAdmin()) {
            System.out.println("Отказ в доступе");
        } else if (quantity > admin.getCashOfAdmin()) {
            System.out.println("Нету столько денег");
        } else if (quantity % 5 != 0) {
            System.out.println("Данную сумму нельзя внести денег");
        } else {
            int newQuintity = quantity;
            calculatingManipulationWithTypeOfMoney(newQuintity,bankomat,admin,imaginaryObjectsForBankomat(bankomat,admin),imaginaryObjectsForAdmin(admin));
        }
    }

    public void getCashFromCard(int quantity,User user,Bankomat bankomat) {
        if(quantity>user.getBalanceOfUser()){
            System.out.println("Не хватает средств на счете");
            return;
        }
        if(quantity%5!=0 || quantity<0){
            System.out.println("Введите в другом формате");
            return;
        }
        Bankomat bankomatForUser = imaginaryObjectsForBankomatForUser(bankomat);
        User newUser = imaginaryObjectsForUser(user);
        int newQuintity = quantity;
        calculatingManipulationWithTypeOfMoneyForUser(newQuintity,bankomat,bankomatForUser,newUser,user);


    }


    private int getFiveTypeOfMoney() {
        return fiveTypeOfMoney;
    }

    private void setFiveTypeOfMoney(int fiveTypeOfMoney) {
        this.fiveTypeOfMoney = fiveTypeOfMoney;
    }

    private int getTenTypeOfMoney() {
        return tenTypeOfMoney;
    }

    private void setTenTypeOfMoney(int tenTypeOfMoney) {
        this.tenTypeOfMoney = tenTypeOfMoney;
    }

    private int getTwentyTypeOfMoney() {
        return twentyTypeOfMoney;
    }

    private int getBalanceOfBankomat() {
        return balanceOfBankomat;
    }

    private void setBalanceOfBankomat(int balanceOfBankomat) {
        this.balanceOfBankomat = balanceOfBankomat;
    }

    private void setTwentyTypeOfMoney(int twentyTypeOfMoney) {
        this.twentyTypeOfMoney = twentyTypeOfMoney;
    }

    private int getFiftyTypeOfMoney() {
        return fiftyTypeOfMoney;
    }

    private void setFiftyTypeOfMoney(int fiftyTypeOfMoney) {
        this.fiftyTypeOfMoney = fiftyTypeOfMoney;
    }

   private Bankomat imaginaryObjectsForBankomat(Bankomat bankomat,Admin admin){
        Bankomat newBankomat = new Bankomat("imaginaryBankomat", bankomat.maxSizeOfMoney, bankomat.fiveTypeOfMoney, bankomat.tenTypeOfMoney, bankomat.twentyTypeOfMoney, bankomat.fiftyTypeOfMoney, bankomat.passwordForAdmin,admin);
        return newBankomat;
    }
    private Bankomat imaginaryObjectsForBankomatForUser(Bankomat bankomat){
        Bankomat bankomatForUser = new Bankomat("imaginaryBankomatForUser", bankomat.maxSizeOfMoney, bankomat.fiveTypeOfMoney, bankomat.tenTypeOfMoney, bankomat.twentyTypeOfMoney, bankomat.fiftyTypeOfMoney);
        return bankomatForUser;
    }
    private User imaginaryObjectsForUser(User user){
        User newUser = new User(user.getFiveTypeOfMoney(), user.getTenTypeOfMoney(),user.getTwentyTypeOfMoney(),user.getFiftyTypeOfMoney(),user.getBalanceOfUser());
        int w = newUser.getTenTypeOfMoney();
        return newUser;
    }

    private Admin imaginaryObjectsForAdmin(Admin admin){
        Admin newAdmin = new Admin(admin.getFiveTypeOfMoney(), admin.getTenTypeOfMoney(), admin.getTwentyTypeOfMoney(), admin.getFiftyTypeOfMoney());
        return newAdmin;
    }

    private void calculatingManipulationWithTypeOfMoney(int quantity, Bankomat bankomat, Admin admin, Bankomat newBankomat, Admin newAdmin) {

        if (quantity >= 50 && newAdmin.getFiftyTypeOfMoney() > 0) {
            newAdmin.setFiftyTypeOfMoney(newAdmin.getFiftyTypeOfMoney() - 1);
            newBankomat.setFiftyTypeOfMoney(newBankomat.getFiftyTypeOfMoney() + 1);
            if (quantity - 50 == 0) {
                zeroCheck(newBankomat, bankomat, admin, newAdmin);
                return;
            } else {
                calculatingManipulationWithTypeOfMoney(quantity - 50, bankomat, admin, newBankomat, newAdmin);
            }
        } else if (quantity >= 20 && newAdmin.getTwentyTypeOfMoney() > 0) {
            newAdmin.setTwentyTypeOfMoney(newAdmin.getTwentyTypeOfMoney() - 1);
            int q = newAdmin.getTwentyTypeOfMoney();
            newBankomat.setTwentyTypeOfMoney(newBankomat.getTwentyTypeOfMoney() + 1);
            int w = newBankomat.getTwentyTypeOfMoney();
            if (quantity - 20 == 0) {
                zeroCheck(newBankomat, bankomat, admin, newAdmin);
                return;
            } else {
                calculatingManipulationWithTypeOfMoney(quantity - 20, bankomat, admin, newBankomat, newAdmin);
            }
        } else if (quantity >= 10 && newAdmin.getTenTypeOfMoney() > 0) {
            newAdmin.setTenTypeOfMoney(newAdmin.getTenTypeOfMoney() - 1);
            int t = newAdmin.getTenTypeOfMoney();
            newBankomat.setTenTypeOfMoney(newBankomat.getTenTypeOfMoney() + 1);
            int y = newBankomat.getTenTypeOfMoney();
            if (quantity - 10 == 0) {
                zeroCheck(newBankomat, bankomat, admin, newAdmin);
                return;
            } else {
                calculatingManipulationWithTypeOfMoney(quantity - 10, bankomat, admin, newBankomat, newAdmin);
            }
        } else if (quantity >= 5 && newAdmin.getFiveTypeOfMoney() > 0) {
            newAdmin.setFiveTypeOfMoney(newAdmin.getFiveTypeOfMoney() - 1);
            int e = newAdmin.getFiveTypeOfMoney();
            newBankomat.setFiveTypeOfMoney(newBankomat.getFiveTypeOfMoney() + 1);
            int r = newBankomat.getFiveTypeOfMoney();
            if (quantity - 5 == 0) {
                zeroCheck(newBankomat, bankomat, admin, newAdmin);
                return;
            } else {
                calculatingManipulationWithTypeOfMoney(quantity - 5, bankomat, admin, newBankomat, newAdmin);
            }
        }
        //System.out.println("Данная операция не возмона");

    }

    private void calculatingManipulationWithTypeOfMoneyForUser(int quantity, Bankomat bankomat, Bankomat bankomatForUser ,User newUser, User user) {

        if (quantity >= 50 && bankomatForUser.getFiftyTypeOfMoney() > 0) {
            bankomatForUser .setFiftyTypeOfMoney(bankomatForUser.getFiftyTypeOfMoney() - 1);
            newUser.setFiftyTypeOfMoney(newUser.getFiftyTypeOfMoney() + 1);
            newUser.setBalanceOfUser(newUser.getBalanceOfUser()-50);
            if (quantity - 50 == 0) {
                zeroCheckForUser(bankomatForUser ,bankomat,user,newUser);
                return;
            } else {
                calculatingManipulationWithTypeOfMoneyForUser(quantity - 50, bankomat, bankomatForUser , newUser,user);
            }
        } else if (quantity >= 20 && bankomatForUser.getTwentyTypeOfMoney() > 0) {
            bankomatForUser.setTwentyTypeOfMoney(bankomatForUser.getTwentyTypeOfMoney() - 1);
            newUser.setTwentyTypeOfMoney(newUser.getTwentyTypeOfMoney() + 1);
            newUser.setBalanceOfUser(newUser.getBalanceOfUser()-20);
            if (quantity - 20 == 0) {
                zeroCheckForUser(bankomatForUser,bankomat,user,newUser);
                return;
            } else {
                calculatingManipulationWithTypeOfMoneyForUser(quantity - 20, bankomat, bankomatForUser , newUser,user);
            }
        } else if (quantity >= 10 && bankomatForUser.getTenTypeOfMoney() > 0) {
            bankomatForUser.setTenTypeOfMoney(bankomatForUser.getTenTypeOfMoney() - 1);
            newUser.setTenTypeOfMoney(newUser.getTenTypeOfMoney() + 1);
            newUser.setBalanceOfUser(newUser.getBalanceOfUser()-10);
            if (quantity - 10 == 0) {
                zeroCheckForUser(bankomatForUser,bankomat,user,newUser);
                return;
            } else {
                calculatingManipulationWithTypeOfMoneyForUser(quantity - 10, bankomat, bankomatForUser, newUser,user);
            }
        } else if (quantity >= 5 && bankomatForUser.getFiveTypeOfMoney() > 0) {
            bankomatForUser.setFiveTypeOfMoney(bankomatForUser.getFiveTypeOfMoney() - 1);
            newUser.setFiveTypeOfMoney(newUser.getFiveTypeOfMoney() + 1);
            newUser.setBalanceOfUser(newUser.getBalanceOfUser()-5);
            if (quantity - 5 == 0) {
                zeroCheckForUser(bankomatForUser,bankomat,user,newUser);
                return;
            } else {
                calculatingManipulationWithTypeOfMoneyForUser(quantity - 5, bankomat, bankomatForUser, newUser,user);
            }
        }
        //System.out.println("Данная операция не возмона");

    }
    private void zeroCheck(Bankomat newBankomat,Bankomat bankomat,Admin admin,Admin newAdmin){
        bankomat.setFiveTypeOfMoney(newBankomat.getFiveTypeOfMoney());
        bankomat.setTenTypeOfMoney(newBankomat.getTenTypeOfMoney());
        bankomat.setTwentyTypeOfMoney(newBankomat.getTwentyTypeOfMoney());
        bankomat.setFiftyTypeOfMoney(newBankomat.getFiftyTypeOfMoney());
        admin.setFiveTypeOfMoney(newAdmin.getFiveTypeOfMoney());
        admin.setTenTypeOfMoney(newAdmin.getTenTypeOfMoney());
        admin.setTwentyTypeOfMoney(newAdmin.getTwentyTypeOfMoney());
        admin.setFiftyTypeOfMoney(newAdmin.getFiftyTypeOfMoney());
        }
    private void zeroCheckForUser(Bankomat newBankomat,Bankomat bankomat,User user,User newUser){
        bankomat.setFiveTypeOfMoney(newBankomat.getFiveTypeOfMoney());
        bankomat.setTenTypeOfMoney(newBankomat.getTenTypeOfMoney());
        bankomat.setTwentyTypeOfMoney(newBankomat.getTwentyTypeOfMoney());
        bankomat.setFiftyTypeOfMoney(newBankomat.getFiftyTypeOfMoney());
        user.setFiveTypeOfMoney(newUser.getFiveTypeOfMoney());
        user.setTenTypeOfMoney(newUser.getTenTypeOfMoney());
        user.setTwentyTypeOfMoney(newUser.getTwentyTypeOfMoney());
        user.setFiftyTypeOfMoney(newUser.getFiftyTypeOfMoney());
        user.setBalanceOfUser(newUser.getBalanceOfUser());
    }

}

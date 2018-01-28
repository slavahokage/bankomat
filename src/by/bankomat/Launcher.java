package by.bankomat;

/**
 * Bankomat ver 1.0
 *
 * Команды Админа для банкомата
 *
 * bankomat.checkBalanceByAdmin(int passwordForAdmin, Bankomat bankomat); - Проверка баланса банкомата
 * bankomat.getQuantityTypeOfMoney(int typeOfMoney, int passwordForAdmin); - Проверка наличия определенного типа купюр
 * bankomat.getAllQuantityTypeOfMoney(int passwordForAdmin,Bankomat bankomat); - Вывод всех типов купюр в банкомате
 * bankomat.replenishAccountBalanceOfBankomat(Admin admin,int quantity,Bankomat bankomat); -Повышение баланса банкомата Админом
 *
 * Команды Админа
 * admin.getQuantityAdminTypeOfMoney(Admin admin); - Вывод всех типов купюр админа
 *
 * Команды Юзера для банкомата
 * bankomat.getCashFromCard(int quantity,User user,Bankomat bankomat); - Снятие денег с карточки
 * bankomat.findOutTheAmountOfMoneyOnTheCard(User user); - Узнать счет на карточке
 *
 * Команды Юзера
 * user.cashOfUser(); - Узнать количество наличных средств
 */

public class Launcher {
    public static void main(String[] args) {
        Admin admin = new Admin(2,1,1,2);
        User user = new User(5,5,5,5,1000);
        Bankomat bankomat = new Bankomat("typicalBankomatInMinsk",1000000,5,0,0,100,12345,admin);

        bankomat.checkBalanceByAdmin(12345,bankomat);
        bankomat.getAllQuantityTypeOfMoney(12345,bankomat);
        admin.getQuantityAdminTypeOfMoney(admin);
        bankomat.replenishAccountBalanceOfBankomat(admin,25,bankomat);
        bankomat.checkBalanceByAdmin(12345,bankomat);
        bankomat.getAllQuantityTypeOfMoney(12345,bankomat);
        admin.getQuantityAdminTypeOfMoney(admin);
        bankomat.findOutTheAmountOfMoneyOnTheCard(user);
        System.out.println(user.cashOfUser());
        bankomat.getQuantityUserTypeOfMoney(user);
        bankomat.getCashFromCard(10,user,bankomat);
        bankomat.getAllQuantityTypeOfMoney(12345,bankomat);
        bankomat.getQuantityUserTypeOfMoney(user);
        bankomat.findOutTheAmountOfMoneyOnTheCard(user);
        System.out.println(user.cashOfUser());
    }

}

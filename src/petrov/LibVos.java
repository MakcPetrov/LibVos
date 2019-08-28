package petrov;

public class LibVos {

    public static void main(String[] args) {

        if (Set.debug_mode) Set.out(DBManager.testDB());

        User user = new User();//создать экземпляр пользака
        new MainWindow(user);//создать окно и дать ему юзера

    }

}

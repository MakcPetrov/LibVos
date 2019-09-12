package petrov;

public class LibVos {

    public static void main(String[] args) {

        if (Set.INSTANCE.getDebug_mode()) Set.INSTANCE.out(DBManager.testDB());

        User user = new User();//создать экземпляр пользака
        new MainWindow(user);//создать окно и дать ему юзера

    }

}

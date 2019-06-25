package petrov;

public class LibVos {

    public static void main(String[] args) {

        //if (Set.debug_mode)
            Set.out(DBManager.testDB());

        User user = new User();//создать экземпляр пользака и дать ему доступ к данным
        new MainWindow(user);//создать окно и дать ему доступ к данным

    }

}

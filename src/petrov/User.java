package petrov;

public class User { //свойства клиента TODO внести сюда чтение из базы юзеров

    public User() {  }

    private boolean online;//прошёл проверку
    private String nick;//имя
    private boolean admin;//библиотекарь

    boolean isOnline() {
        return online;
    }

    void setOnline() {
        this.online = true;
    }

    void setOffline() {
        this.online = false;
    }

    String getNick() {
        return nick;
    }

//    void setNick(String nick) {
//        this.nick = nick;
//    }

    public boolean isAdmin() {
        return admin;
    }

//    public void setAdmin(boolean admin) {
//        this.admin = admin;
//    }

    void auth(String login, String password) {
        //TODO запрос к базе (AUTH + " " + login + " " + password);, а пока всё счиитаем ОК
        String psh="71";
        if (Set.debug_mode) System.out.println(login + password);

//        if (DBManager.getInstance().checkUser(login, password))
        if (DBManager.checkUser(login, password))
        {//логин успешен
            nick = "Гыук"; //заглушка
            online = true;
            admin = true;
            if (Set.debug_mode) System.out.println("OK");
        }//логин успешен
        else
        {//логин неуспешен
            nick = ""; //заглушка
            online = false;
            admin = false;
            if (Set.debug_mode) System.out.println("DEN");
        }//логин неуспешен
    }

}//User

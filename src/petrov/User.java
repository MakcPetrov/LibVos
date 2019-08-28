package petrov;

public class User { //свойства клиента TODO внести сюда чтение из базы юзеров

    public User() {  }

    private boolean online;//прошёл проверку
    private String nick;//имя
    private boolean admin;//библиотекарь

    boolean isOnline() {
//        Set.out(nick + " online "+online);
        return online;
    }

//    void setOnline() {
//        this.online = true;
//        Set.out(nick + "  in");
//    }

    void setOffline() {
        this.online = false;
        this.nick=Set.noUser;
        Set.out(nick + " out");
    }

    String getNick() {
        if (nick==null) nick = Set.noUser;
        //Set.out("get "+nick);
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

        if(Set.debug_mode){//пропускаем логин, ставим юзера по дефолту
            nick = Set.testUser; //заглушка
            online = true;
            admin = true;
            Set.out( getNick()+ " GRANTED");
        }else
//       if (DBManager.getInstance().checkUser(login, password))
            if (DBManager.checkUser(login, password))
            {//логин успешен
                online = true;
                admin = true;
                Set.out( getNick()+ " GRANTED");
            }//логин успешен
            else
            {//логин неуспешен
                nick = Set.noUser;
                online = false;
                admin = false;
                if (Set.debug_mode) System.out.println(" DENIED");
            }//логин неуспешен
    }
}//User

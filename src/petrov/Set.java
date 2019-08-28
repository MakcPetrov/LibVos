package petrov;

class Set {//параметры программы
    static boolean debug_mode=true; //для отладки, если true - выводим в лог

    //TODO сделать чтение, сохранение и окно настроек
    static String TAG = "LbVos_: ";
    static String url = "jdbc:mysql://192.168.1.52:3306/libary?serverTimezone=Europe/Moscow";
    static String user = "user";//логин-пароль СУБД
    static String password = "1111";//логин-пароль СУБД

    //имена объектов
    static String noUser ="zombie";
    static String testUser ="morph";
    static String loginBt ="login";
    static String books ="books";
    static String ovner ="ovner";
    static String path ="path";
    static String newBook = "newBooks";
    static String users = "users";
    static String newUser = "newUser";
    static String preferences = "Preferences";
    static String logs = "logs";
    static String lists = "lists";


    static void out(String logString){//вывод строки в лог TODO сделать возможность вывода в файл и т.п.
        if (debug_mode) System.out.println(TAG + logString);
    }//out вывод строки в лог

}//Set параметры программы

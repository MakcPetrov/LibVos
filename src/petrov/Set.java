package petrov;

class Set {//параметры программы
    static boolean debug_mode=true; //для отладки, если true - выводим в лог

    //TODO сделать чтение, сохранение и окно настроек
    static final String TAG = "LbVos_: ";
    static final String url = "jdbc:mysql://192.168.1.52:3306/libary?serverTimezone=Europe/Moscow";
    static final String user = "user";
    static final String password = "1111";

    static void out(String logString){//вывод строки в лог TODO сделать возможность вывода в файл и т.п.
        if (debug_mode) System.out.println(TAG + logString);
    }//out вывод строки в лог
}//Set параметры программы

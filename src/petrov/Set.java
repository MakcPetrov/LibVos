package petrov;

class Set {//параметры программы
    static boolean debug_mode=true; //для отладки, если true - выводим в лог

    //TODO сделать чтение, сохранение и окно настроек
    static final String TAG = "LbVos_: ";
    static final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Europe/Moscow";
    static final String user = "user";
    static final String password = "1111";

    static void out(String logString){//вывод строки в лог TODO сделать возможность вывода в файл и т.п.
        if (debug_mode) System.out.println(TAG + logString);
    }//out вывод строки в лог
}//Set параметры программы

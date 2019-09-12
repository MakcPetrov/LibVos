package petrov

//параметры программы
internal object Set {

    var debug_mode = true //для отладки, если true - выводим в лог

    //TODO сделать чтение, сохранение и окно настроек
    var TAG = "LbVos "
    var url = "jdbc:mysql://192.168.1.52:3306/libary?serverTimezone=Europe/Moscow"
    var user = "user"//логин-пароль СУБД
    var password = "1111"//логин-пароль СУБД

    //имена объектов
    var exit = "exit"
    var noUser = "zombie"
    var testUser = "morph"
    var loginBt = "login"
    var books = "books"
    var owner = "owner"
    var path = "path"
    var newBook = "newBooks"
    var users = "users"
    var newUser = "newUser"
    var preferences = "Preferences"
    var logs = "logs"
    var lists = "lists"


    fun out(logString: String) {//вывод строки в лог TODO сделать возможность вывода в файл и т.п.
        if (debug_mode) println(TAG + logString)
    }//out вывод строки в лог

}//Set параметры программы

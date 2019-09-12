package petrov

object LibVos {

    @JvmStatic
    fun main(args: Array<String>) {

        if (Set.debug_mode) Set.out(DBManager.testDB())

        val user = User()//создать экземпляр пользака
        MainWindow(user)//создать окно и дать ему юзера

    }

}

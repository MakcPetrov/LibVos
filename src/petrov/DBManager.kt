package petrov

import java.sql.Connection
import java.sql.DriverManager
import java.sql.DriverManager.*
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

internal object DBManager {//Менеджер базы данных
    //private static volatile DBManager instance;
    //TODO: сделать лог-файл if (Set.debug_mode)

    private var connection: Connection? = null
    private var statement: Statement? = null
    private var resultSet: ResultSet? = null

    fun testDB(): String {
        val query = "select count(*) from books"

        try {
            connection = getConnection(Set.url, Set.user, Set.password)
            statement = connection!!.createStatement()
            resultSet = statement!!.executeQuery(query)

            while (resultSet!!.next()) {
                val count = resultSet!!.getInt(1)
                return "items: $count"
                //if (Set.debug_mode)System.out.println("Total number of books in the table : " + count);
            }

        } catch (sqlEx: SQLException) {
            sqlEx.printStackTrace()
            return "SQL access Error"
        } finally {
            //close connection ,statement and resultset here
            try {
                connection!!.close()
            } catch (se: SQLException) {
            }

            try {
                statement!!.close()
            } catch (se: SQLException) {
            }

            try {
                resultSet!!.close()
            } catch (se: SQLException) {
            }

        }
        return "SQL access Error"
    }


    fun checkUser(login: String, password: String): Boolean {//User & passwd
        //password = password;//здесь можно вставить шифрование пароля для хранения в базе
        val outBD: ResultSet?
        try {
            outBD = statement!!.executeQuery("SELECT pswd FROM clients WHERE login = '$login'")
            if (outBD != null && outBD.next() && password == outBD.getString("pswd"))
                return true
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return false//User not found or password failure
    }//checkUser: проверить пароль у юзера, при любой ошибке false


    //    private DBManager() {//конструктор + подключение к БД
    //        try {
    //            Class.forName("org.mysql.JDBC");
    //            connect = DriverManager.getConnection("jdbc:mysql:"+ Set.BDpath);
    //            statement = connect.createStatement();
    //            if (Set.debug_mode) System.out.println("connect BD");
    //            if (newBase) { //создать базу с нуля
    //                failure=newBase(Set.clientsBD);
    //                failure=newBase(Set.booksBD);
    //            }//создать базу с нуля
    //        } catch (SQLException | ClassNotFoundException e) {
    //            failure=true;//авария (потом проверять будем)
    //            e.printStackTrace();
    //      }
    //  }//конструктор + подключение к БД

    //    public static DBManager getInstance() {
    //        DBManager localInstance = instance;
    //        if (localInstance == null) {
    //            synchronized (DBManager.class) {
    //                localInstance = instance;
    //                if (localInstance == null) {
    //                    instance = localInstance = new DBManager();
    //                }
    //            }
    //        }
    //        return localInstance;
    //    }

}




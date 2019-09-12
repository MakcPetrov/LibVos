package petrov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DBManager {//Менеджер базы данных
    //private static volatile DBManager instance;
    //TODO: сделать лог-файл if (Set.debug_mode)

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    static String testDB() {
        String query = "select count(*) from books";

        try {
            connection = DriverManager.getConnection(Set.INSTANCE.getUrl(), Set.INSTANCE.getUser(), Set.INSTANCE.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                return "items: " + count;
                //if (Set.debug_mode)System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return "SQL access Error";
        } finally {
            //close connection ,statement and resultset here
            try { connection.close(); } catch(SQLException se) {}
            try { statement.close(); } catch(SQLException se) {}
            try { resultSet.close(); } catch(SQLException se) {}
        }
        return "SQL access Error";
    }


    static boolean checkUser(String login, String password)
    {//User & passwd
        //password = password;//здесь можно вставить шифрование пароля для хранения в базе
        ResultSet outBD;
        try {
            outBD = statement.executeQuery("SELECT pswd FROM clients WHERE login = '"+login+"'");
            if (outBD !=null && outBD.next()&& password.equals(outBD.getString("pswd")))
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;//User not found or password failure
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




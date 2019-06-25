package petrov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DBManager {//Менеджер базы данных
    //private static volatile DBManager instance;
    //TODO: сделать лог-файл if (Vars.debug_mode)


    static private Connection connect;
    static private Statement statement;


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
//            connect = DriverManager.getConnection("jdbc:mysql:"+ Vars.BDpath);
//            statement = connect.createStatement();
//            if (Vars.debug_mode) System.out.println("connect BD");
//            if (newBase) { //создать базу с нуля
//                failure=newBase(Vars.clientsBD);
//                failure=newBase(Vars.booksBD);
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

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://petrov:3306/library?serverTimezone=Europe/Moscow";
    private static final String user = "user";
    private static final String password = "1111";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    static void testDB() {
        String query = "select count(*) from books";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}




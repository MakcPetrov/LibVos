package petrov;

import javax.swing.*;
import java.awt.*;

class MainWindow extends JFrame {

    private JPanel workPanel;//панель работы
    private JPanel loginPanel;//панель авторизации
    private JPanel controlPanel;//панель команд

    MainWindow(User user){

        //описание основного окна программы
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);//а пусть будет
        setTitle(Set.INSTANCE.getTAG());
        JTextField login = new JTextField();
        JPasswordField password = new JPasswordField();

        //панель авторизации
        loginPanel = new JPanel(new GridLayout(1, 3));
        login.setText(user.getNick());
        password.addActionListener(e -> {//ентер пассворд
            user.auth(login.getText(), new String(password.getPassword()));
            switchWindows(user);//включаем в актуальный режим
            password.setText("");
        });//password.ActionListener
        JButton authIn = new JButton(Set.INSTANCE.getLoginBt());//кнопка авторизации
        authIn.addActionListener(e -> {
            user.auth(login.getText(), new String(password.getPassword()));
            switchWindows(user);//включаем в актуальный режим
            password.setText("");
        });//кнопка авторизации

        loginPanel.add(login);
        loginPanel.add(password);
        loginPanel.add(authIn);

        //панель команд
        controlPanel = new JPanel(new GridLayout(1, 2));//сюда складываем элементы управления

        //рабочая панель
        workPanel = new JPanel(new GridLayout(20, 3));
        JTextField username = new JTextField();
        username.setText(user.getNick());
        workPanel.add(username);

        //кнопки вызова режимов работы

        JButton bookListButon = new JButton(Set.INSTANCE.getBooks());
        bookListButon.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getBooks());
            BookListWindow bookListWindow = new BookListWindow();
        });

        JButton newBookButton = new JButton(Set.INSTANCE.getNewBook());
        newBookButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getNewBook());
        });

        JButton userListButton = new JButton(Set.INSTANCE.getUsers());
        userListButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getUsers());
        });

        JButton newUserButton = new JButton(Set.INSTANCE.getNewUser());
        newUserButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getNewUser());
        });

        JButton preferencesButton = new JButton(Set.INSTANCE.getPreferences());
        preferencesButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getPreferences());
            PreferencesWindows preferencesWindows = new PreferencesWindows();
        });

        JButton logsButton = new JButton(Set.INSTANCE.getLogs());
        logsButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getLogs());
        });

        JButton listsButton = new JButton(Set.INSTANCE.getLists());
        listsButton.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getLists());
        });

        JButton logoutButton  = new JButton("Logout");//кнопка выхода
        logoutButton.addActionListener(e -> {
            user.setOffline();
            switchWindows(user);//включаем в актуальный режим
            //login.setText("");//обнулить имя
            password.setText("");
        });

        JButton exitButon = new JButton(Set.INSTANCE.getExit());
        exitButon.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getExit());
            System.exit(1);
//            setVisible(false);
        });

        workPanel.add(bookListButon);
        workPanel.add(newBookButton);
        workPanel.add(userListButton);
        workPanel.add(newUserButton);
        workPanel.add(logsButton);
        workPanel.add(listsButton);

        workPanel.add(preferencesButton);
        workPanel.add(logoutButton);
        workPanel.add(exitButon);

        add(workPanel, BorderLayout.CENTER);//главное окно занимает весь бокс
        add(loginPanel, BorderLayout.NORTH);//сверху панель логина
        add(controlPanel, BorderLayout.SOUTH);//снизу элементы ввода
        switchWindows(user);//включаем в актуальный режим
        setVisible(true);
    }//MainWindow

    private void switchWindows(User user) {//меняем вид окна при подключении-отключении
        setTitle(user.getNick());//меняем имя окна
        loginPanel.setVisible(!user.isOnline());//показывать, если юзера нет
        workPanel.setVisible(user.isOnline());//показывать, если юзер онлайн
        controlPanel.setVisible(true);//показывать
//        controlPanel.setVisible(user.isOnline());//показывать, если юзер онлайн
    }//switchWindows

}

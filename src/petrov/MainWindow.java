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
        JButton authIn = new JButton(Set.loginBt);//кнопка авторизации
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

        JButton bookListButon = new JButton(Set.books);
        bookListButon.addActionListener(e -> {
            Set.out(Set.books);
            BookList bookList = new BookList();
        });

        JButton newBookButton = new JButton(Set.newBook);
        newBookButton.addActionListener(e -> {
            Set.out(Set.newBook);
        });

        JButton userListButton = new JButton(Set.users);
        userListButton.addActionListener(e -> {
            Set.out(Set.users);
        });

        JButton newUserButton = new JButton(Set.newUser);
        newUserButton.addActionListener(e -> {
            Set.out(Set.newUser);
        });

        JButton preferencesButton = new JButton(Set.preferences);
        preferencesButton.addActionListener(e -> {
            Set.out(Set.preferences);
        });

        JButton logsButton = new JButton(Set.logs);
        logsButton.addActionListener(e -> {
            Set.out(Set.logs);
        });

        JButton listsButton = new JButton(Set.lists);
        listsButton.addActionListener(e -> {
            Set.out(Set.lists);
        });

        JButton logoutButton  = new JButton("Logout");//кнопка выхода
        logoutButton.addActionListener(e -> {
            user.setOffline();
            switchWindows(user);//включаем в актуальный режим
            //login.setText("");//обнулить имя
            password.setText("");
        });

        workPanel.add(bookListButon);
        workPanel.add(newBookButton);
        workPanel.add(userListButton);
        workPanel.add(newUserButton);
        workPanel.add(logsButton);
        workPanel.add(listsButton);

        workPanel.add(preferencesButton);
        workPanel.add(logoutButton);

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

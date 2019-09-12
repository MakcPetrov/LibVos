package petrov;

import javax.swing.*;

public class BookListWindow extends JFrame {
    BookListWindow(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);//а пусть будет
        setTitle(Set.INSTANCE.getBooks());

        Set.INSTANCE.out("BookList created");
    }//BookList

}

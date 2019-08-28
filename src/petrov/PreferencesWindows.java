package petrov;

import javax.swing.*;
import java.awt.*;


public class PreferencesWindows extends JFrame {

    PreferencesWindows(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);//а пусть будет
        setTitle(Set.preferences);
        Set.out("Preferences created");

        //панель работы
        JPanel workPanel = new JPanel(new GridLayout(20, 3));

        JButton ownerButon = new JButton(Set.owner);
        ownerButon.addActionListener(e -> {
            Set.out(Set.owner);
        });

        JButton pathButon = new JButton(Set.path);
        pathButon.addActionListener(e -> {
            Set.out(Set.path);
        });

        JButton exitButon = new JButton(Set.exit);
        exitButon.addActionListener(e -> {
            Set.out(this.getTitle() + " " + Set.exit);
            setVisible(false);
        });

        workPanel.add(ownerButon);
        workPanel.add(pathButon);
        workPanel.add(exitButon);



        add(workPanel, BorderLayout.CENTER);//главное окно занимает весь бокс
        setVisible(true);
        Set.out("Preferences closed");
    }//Preferences

}

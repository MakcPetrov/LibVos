package petrov;

import javax.swing.*;
import java.awt.*;


public class PreferencesWindows extends JFrame {

    PreferencesWindows(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);//а пусть будет
        setTitle(Set.INSTANCE.getPreferences());
        Set.INSTANCE.out("Preferences created");

        //панель работы
        JPanel workPanel = new JPanel(new GridLayout(20, 3));

        JButton ownerButon = new JButton(Set.INSTANCE.getOwner());
        ownerButon.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getOwner());
        });

        JButton pathButon = new JButton(Set.INSTANCE.getPath());
        pathButon.addActionListener(e -> {
            Set.INSTANCE.out(Set.INSTANCE.getPath());
        });

        JButton exitButon = new JButton(Set.INSTANCE.getExit());
        exitButon.addActionListener(e -> {
            Set.INSTANCE.out(this.getTitle() + " " + Set.INSTANCE.getExit());
            setVisible(false);
        });

        workPanel.add(ownerButon);
        workPanel.add(pathButon);
        workPanel.add(exitButon);



        add(workPanel, BorderLayout.CENTER);//главное окно занимает весь бокс
        setVisible(true);
        Set.INSTANCE.out("Preferences closed");
    }//Preferences

}

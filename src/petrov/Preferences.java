package petrov;

import javax.swing.*;
import java.awt.*;


public class Preferences extends JFrame {

    private JPanel workPanel;//������ ������

    Preferences(){
    Set.out("Preferences created");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);//� ����� �����

        workPanel = new JPanel(new GridLayout(20, 3));

        JButton ovnerButon = new JButton(Set.ovner);
        ovnerButon.addActionListener(e -> {
            Set.out(Set.ovner);
        });

        JButton pathButon = new JButton(Set.path);
        pathButon.addActionListener(e -> {
            Set.out(Set.path);
        });

        workPanel.add(ovnerButon);
        workPanel.add(pathButon);
        add(workPanel, BorderLayout.CENTER);//������� ���� �������� ���� ����
        setVisible(true);

    }//Preferences

}

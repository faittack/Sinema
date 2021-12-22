package View;

import Codes.Kullanıcılar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame{

    private static Kullanıcılar kullanıcılar=new Kullanıcılar();
    private JTable user_CineTable;
    private JButton btn_UserSerch;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox ComBox_UserType;
    private JPanel User_JPanel;


    public UserGUI(Kullanıcılar kullanıcılar){
        add(User_JPanel);
        setBounds(600, 250, 600, 500);
        setTitle("Kullanıcı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        user_CineTable.setModel(Kullanıcılar.cinemaList());


        ComBox_UserType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void openUserGUI(){
        UserGUI userGUI=new UserGUI(kullanıcılar);
        userGUI.setVisible(true);


    }
}

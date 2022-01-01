package View;

import Codes.Kullanıcılar;
import Codes.Sinema;
import Helper.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

public class UserGUI extends JFrame {

    private static Kullanıcılar kullanıcılar = new Kullanıcılar();
    private JTable user_CineTable;
    private JButton btn_UserSerch;
    private JComboBox cmdBox_Point;
    private JComboBox cmdBox_Year;
    private JComboBox cmdBox_Type;
    private JPanel User_JPanel;
    private JButton btn_UserTablo;
    public static ArrayList<Sinema> SearchList = new ArrayList<>();


    public UserGUI(Kullanıcılar kullanıcılar) {
        add(User_JPanel);
        setBounds(600, 250, 600, 500);
        setTitle("Kullanıcı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        user_CineTable.setModel(Kullanıcılar.cinemaList());

        btn_UserSerch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean bol = false;

                if (cmdBox_Point.getSelectedItem().equals("Seçiniz") || cmdBox_Year.getSelectedItem().equals("Seçiniz") || cmdBox_Type.getSelectedItem().equals("Seçiniz")) {
                    Messages.showMesaj("fill");
                } else {

                    ArrayList<Sinema> list = new ArrayList<>();

                    Sinema obj;

                    for (int i = 0; i < kullanıcılar.getCinemaList().size(); i++) {

                        if (kullanıcılar.getCinemaList().get(i).getCinema_IMDB() >= Float.parseFloat(cmdBox_Point.getSelectedItem().toString()) && kullanıcılar.getCinemaList().get(i).getCinema_yil() >= Integer.parseInt(cmdBox_Year.getSelectedItem().toString()) && cmdBox_Type.getSelectedItem().toString().equals(kullanıcılar.getCinemaList().get(i).getCinema_type())) {

                            obj = new Sinema(kullanıcılar.getCinemaList().get(i).getCinema_Ad(), kullanıcılar.getCinemaList().get(i).getCinema_type(), kullanıcılar.getCinemaList().get(i).getCinema_IMDB(), kullanıcılar.getCinemaList().get(i).getCinema_yil(), kullanıcılar.getCinemaList().get(i).getDirector());

                            list.add(obj);

                            bol=true;
                        }
                    }
                    SearchList = list;
                    if (bol){
                        user_CineTable.setModel(kullanıcılar.UpdateCinemaList());
                        cmdBox_Type.setSelectedIndex(0);
                        cmdBox_Point.setSelectedIndex(0);
                        cmdBox_Year.setSelectedIndex(0);
                    }else {
                        Messages.showMesaj("not found");
                    }

                }
            }
        });

        btn_UserTablo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user_CineTable.setModel(Kullanıcılar.cinemaList());
            }
        });
    }

    public static void openUserGUI() {
        UserGUI userGUI = new UserGUI(kullanıcılar);
        userGUI.setVisible(true);


    }
}

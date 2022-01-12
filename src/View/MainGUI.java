package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Codes.Admin;
import Helper.*;

import static View.AdminGUI.*;

public class MainGUI extends JFrame {
    private JPanel fld_JPanel;
    private JTabbedPane tabbedPane1;
    private JPanel tabb_Kullnıcı;
    private JPanel fld_JAdmin;
    private JButton bts_UserEntr;
    private JLabel user_pass;
    private JPasswordField box_AdminPass;
    private JLabel fld_AdName;
    private JLabel lab_AdPass;
    private JPasswordField box_UserPass;
    private JButton butt_Admin;
    private JTextField box_AdName;
    private JTextField box_UserName;
    private JButton btn_register;
    private JLabel fld_UserName;
    private DBConnect conn = new DBConnect();

    public MainGUI() {
        add(fld_JPanel);
        setBounds(600, 250, 400, 300);
        setTitle("Sinemalar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        butt_Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (box_AdName.getText().length() == 0 || box_AdminPass.getText().length() == 0) {
                    Messages.showMesaj("fill");
                } else {
                    try {
                        String type = "Admin";
                        boolean ht = false;
                        Connection con = conn.connDB_Cinema();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM user WHERE Kullanici_type= 'Admin' ");
                        while (rs.next()) {

                            if (box_AdName.getText().equals(rs.getString("Kullanici_Ad")) && box_AdminPass.getText().equals(rs.getString("Kullanici_pass"))) {
                                Admin admin = new Admin();
                                admin.setUser_type(rs.getString("Kullanici_type"));
                                admin.setUser_name(rs.getString("Kullanici_Ad"));
                                admin.setUser_pass(rs.getString("Kullanici_pass"));
                                openAdminGUI();
                                ht = true;
                                box_AdName.setText(null);
                                box_AdminPass.setText(null);
                                setVisible(false);
                                dispose();

                            }
                        }
                        if (!ht) {
                            Messages.showMesaj("wrong");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

        bts_UserEntr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box_UserName.getText().length() == 0 || box_UserPass.getText().length() == 0) {
                    Messages.showMesaj("fill");
                } else {
                    try {
                        boolean ht = false;
                        Connection con = conn.connDB_Cinema();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM user WHERE Kullanici_type='User' ");
                        while (rs.next()) {

                            if (box_UserName.getText().equals(rs.getString("Kullanici_Ad")) && box_UserPass.getText().equals(rs.getString("Kullanici_pass"))) {
                                UserGUI.openUserGUI();
                                ht = true;
                                setVisible(false);
                                dispose();
                            }
                        }
                        if (!ht) {
                            Messages.showMesaj("wrong");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        });
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterGUI.OpenRegisterGUI();
            }
        });
    }

    public static void OpenPanel() {
        MainGUI demo = new MainGUI();
        demo.setVisible(true);
    }


}


package View;

import Helper.DBConnect;
import Helper.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterGUI extends JFrame {
    private JTextField fld_RegisterName;
    private JButton btn_Register;
    private JPasswordField fld_RegisterPass;
    private JPasswordField fld_RegistePassAg;
    private JPanel fld_JUserPanel;
    private DBConnect conn = new DBConnect();


    public RegisterGUI() {
        add(fld_JUserPanel);
        setBounds(600, 250, 400, 300);
        setTitle("Kayıt Ol");



        btn_Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (fld_RegisterName.getText().length() == 0 || fld_RegisterName.getText().length() == 0 || fld_RegistePassAg.getText().length() == 0) {
                    Messages.showMesaj("fill");
                } else if (!fld_RegisterPass.getText().equals(fld_RegistePassAg.getText())) {
                    Messages.showMesaj("Şifreler eşleşmiyor.");

                } else {
                    try {
                        boolean ht = false;

                        Connection con = conn.connDB_Cinema();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM user WHERE Kullanici_type='User' ");
                        while (rs.next()) {
                            if (fld_RegisterName.getText().equals(rs.getString("Kullanici_Ad"))) {
                                ht = true;
                            }
                        }
                        if (ht)
                            Messages.showMesaj("match");
                        if (!ht) {
                            String quary = "INSERT INTO user(Kullanici_Ad,Kullanici_pass,Kullanici_type)" + " VALUES( '" + fld_RegisterName.getText() + "','" + fld_RegisterPass.getText() + "','User') ";
                            st.executeUpdate(quary);
                            Messages.showMesaj("succes");

                            fld_RegisterName.setText(null);
                            fld_RegisterPass.setText(null);
                            fld_RegistePassAg.setText(null);
                            setVisible(false);
                            dispose();

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }




    public static void OpenRegisterGUI() {
        RegisterGUI registerGUI = new RegisterGUI();
        registerGUI.setVisible(true);


    }
}

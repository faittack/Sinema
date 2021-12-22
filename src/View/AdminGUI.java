package View;

import Codes.Admin;
import Codes.Kullanıcılar;
import Helper.Messages;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    static Kullanıcılar kullanıcılar=new Kullanıcılar();
    static AdminGUI adminGUI=new AdminGUI(kullanıcılar);
    static Admin admin=new Admin();
    private JPanel panel1;
    public JTable Sinema_table;
    private JButton btn_remove;
    private JButton btn_add;
    private JTextField fld_FilName;
    private JTextField fld_Filpoint;
    private JTextField fld_Filyear;
    private JComboBox cmd_box;
    private JTabbedPane user_table;
    private JTable admin_UserMenu;
    private JButton btn_adUserRemove;
    private JTextField fld_adUserRemove;
    private JTextField fld_deleteFilmName;
    private JButton btn_adUserSearch;
    private JTextField textField1;


    public AdminGUI(Kullanıcılar kullanıcılar){

        user_table.setTitleAt(1,"Kullanıcı Ayarları");

        add(panel1);
        setBounds(600,250,600,500);
        setTitle("Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        admin_UserMenu.setModel(Admin.userList());

        Sinema_table.setModel(Kullanıcılar.cinemaList());


        Sinema_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    fld_deleteFilmName.setText(Sinema_table.getValueAt(Sinema_table.getSelectedRow(), 0).toString());
                }catch (Exception ex){

                }
            }
        });

        btn_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fld_deleteFilmName.getText().length()!=0){

                        admin.removeFilm(fld_deleteFilmName.getText());

                        Sinema_table.setModel(kullanıcılar.updateSinemaModel(Sinema_table.getModel()));

                        fld_deleteFilmName.setText(null);

                    Messages.showMesaj("succes");

                }


                }

        });

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fld_FilName.getText().length()==0||fld_Filpoint.getText().length()==0||fld_Filyear.getText().length()==0||"Tür Seçiniz !".equals(cmd_box.getSelectedItem())){
                    Messages.showMesaj("fill");

                }else if( Float.parseFloat(fld_Filpoint.getText()) > 10 ||Float.parseFloat(fld_Filpoint.getText())<=0||Integer.parseInt(fld_Filyear.getText())<1900){

                    Messages.showMesaj("hata");

                }else{
                    String name=fld_FilName.getText();
                    String type= (String) cmd_box.getSelectedItem();
                    float point=Float.parseFloat(fld_Filpoint.getText());
                    int year=Integer.parseInt(fld_Filyear.getText());

                    Admin admin=new Admin();
                    admin.addFilm(name,type,point,year);
                    fld_FilName.setText(null);
                    cmd_box.setSelectedIndex(0);
                    fld_Filpoint.setText(null);
                    fld_Filyear.setText(null);
                    Sinema_table.setModel(kullanıcılar.updateSinemaModel(Sinema_table.getModel()));


                }
            }
        });


        btn_adUserSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean key=false;
                if(fld_adUserRemove.getText().length()==0)
                    Messages.showMesaj("fill");
                else {
                    for (int i=0;i<Admin.getUserList().size();i++){
                        if(fld_adUserRemove.getText().equals(Admin.getUserList().get(i).getUser_name())){
                            key=true;
                    }
                        if(key){






                        } else{
                            Messages.showMesaj("hata");
                        }
                    }

                }
            }
        });



    }
    public static void openAdminGUI(){
        AdminGUI adminGUI=new AdminGUI(kullanıcılar);
        adminGUI.setVisible(true);

    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

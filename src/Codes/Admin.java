package Codes;

import Helper.DBConnect;
import Helper.Messages;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class Admin extends Kullanıcılar {

    private PreparedStatement preparedStatement=null;

    public Admin(String User_name, String User_pass, String User_type) {
        super(User_name, User_pass, User_type);
    }

    public Admin() {

    }

    public static ArrayList<Kullanıcılar> getUserList() {
        ArrayList<Kullanıcılar> listarr = new ArrayList<>();
        DBConnect conn = new DBConnect();
        Statement st = null;
        ResultSet rt = null;
        Connection con = conn.connDB_Cinema();
        Kullanıcılar obj;
        try {
            st = con.createStatement();
            rt = st.executeQuery("SELECT * FROM user WHERE Kullanici_type='User'");
            while (rt.next()) {
                obj = new Kullanıcılar(rt.getString("Kullanici_Ad"), rt.getString("Kullanici_pass"), rt.getString("Kullanici_type"));
                listarr.add(obj);
            }
            st.close();
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarr;
    }

    public void addFilm(String filmName,String filmType,float filmPoint,int filmyear){

        try {
            boolean ht = false;

            DBConnect conn = new DBConnect();

            Connection con = conn.connDB_Cinema();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cinema ");
            while (rs.next()) {
                if (filmName.equals(rs.getString("Sinema_Ad"))) {
                    ht = true;
                }
            }
            if(ht)
                Messages.showMesaj("have");
            if (!ht) {
                String quary = "INSERT INTO cinema(Sinema_Ad,Sinema_Tur,Sinema_IMDB,Sinema_Yıl)" + " VALUES( '" + filmName + "','" + filmType + "','" +filmPoint+ "','"+filmyear+ "') ";
                st.executeUpdate(quary);
                Messages.showMesaj("succes");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static TableModel userList() {


        DefaultTableModel userModel = null;
        Object[] userData;

        userModel = new DefaultTableModel();
        Object[] colUser = new Object[2];

        colUser[0] = "Kullanıcı İsmi";
        colUser[1] = "Kullanıcı Şifre";

        userModel.setColumnIdentifiers(colUser);
        userData = new Object[2];
        for (int i = 0; i < Admin.getUserList().size(); i++) {
            userData[0] = Admin.getUserList().get(i).getUser_name();
            userData[1] = Admin.getUserList().get(i).getUser_pass();
            userModel.addRow(userData);
        }

    return userModel;
    }




    public boolean removeFilm(String filmName){
        boolean key=false;
        String quary = "DELETE FROM cinema WHERE Sinema_Ad='"+filmName+"'";
        DBConnect conn = new DBConnect();
        Connection con = conn.connDB_Cinema();
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate(quary);
            key=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (key)
            return true;
        else
            return false;
    }

}




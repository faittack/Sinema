package Codes;

import Helper.DBConnect;
import View.AdminGUI;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kullanıcılar {
    private String User_name;
    private String User_pass;
    private String User_type;
    static Kullanıcılar kullanıcılar=new Kullanıcılar();


    public Kullanıcılar() {


    }

    public Kullanıcılar(String User_Name, String User_pass, String User_type) {
        setUser_name(User_Name);
        setUser_pass(User_pass);
        setUser_type(User_type);
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_pass() {
        return User_pass;
    }

    public void setUser_pass(String user_pass) {
        User_pass = user_pass;
    }

    public String getUser_type() {
        return User_type;
    }

    public void setUser_type(String user_type) {
        User_type = user_type;
    }


    public static TableModel cinemaList() {

        DefaultTableModel sinemaModel = null;
        Object[] sinemaData;

        Kullanıcılar kullanıcılar=new Kullanıcılar();
        sinemaModel = new DefaultTableModel();
        Object[] colSinema = new Object[4];

        colSinema[0] = "Film Adı";
        colSinema[1] = "Film Türü";
        colSinema[2] = "IMDB Puanı";
        colSinema[3] = "Film Yılı";

        sinemaModel.setColumnIdentifiers(colSinema);
        sinemaData = new Object[4];
        for (int i = 0; i < kullanıcılar.getCinemaList().size(); i++) {
            sinemaData[0] = kullanıcılar.getCinemaList().get(i).getCinema_Ad();
            sinemaData[1] = kullanıcılar.getCinemaList().get(i).getCinema_type();
            sinemaData[2] = kullanıcılar.getCinemaList().get(i).getCinema_IMDB();
            sinemaData[3] = kullanıcılar.getCinemaList().get(i).getCinema_yil();
            sinemaModel.addRow(sinemaData);
        }

        return sinemaModel;

    }

    public ArrayList<Sinema> getCinemaList() {
        DBConnect conn = new DBConnect();
        Statement st = null;
        ResultSet rt = null;
        Connection con = conn.connDB_Cinema();
        ArrayList<Sinema> list = new ArrayList<>();
        Sinema obj;
        try {
            st = con.createStatement();
            rt = st.executeQuery("SELECT * FROM cinema");
            while (rt.next()) {
                obj = new Sinema(rt.getString("Sinema_Ad"), rt.getString("Sinema_Tur"), rt.getFloat("Sinema_IMDB"), rt.getInt("Sinema_Yıl"));
                list.add(obj);

            }
            st.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
    public TableModel updateSinemaModel(TableModel tableModel){
        AdminGUI adminGUI=new AdminGUI(kullanıcılar);
        DefaultTableModel clearModel= (DefaultTableModel)tableModel ;
        clearModel.setRowCount(0);
        clearModel= (DefaultTableModel) cinemaList();

        return  clearModel;
    }


}

package Codes;
import View.*;
import Helper.*;

public class Main {
    public static void main(String[] args){
        DBConnect conn=new DBConnect();
        conn.connDB_Cinema();
        MainGUI.OpenPanel();
        Admin admin=new Admin();
        admin.getUserList();


    }
}

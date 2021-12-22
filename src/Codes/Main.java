package Codes;
import View.*;
import java.sql.*;
import Helper.*;

public class Main {
    public static void main(String[] args){
        DBConnect conn=new DBConnect();
        conn.connDB_Cinema();
        Demo.OpenPanel();
        Admin admin=new Admin();
        admin.getUserList();


    }
}

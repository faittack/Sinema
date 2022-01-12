package Helper;
import java.sql.*;

public class DBConnect {

    Connection c=null;

//    Connection d=null;

    public Connection connDB_Cinema(){

        try {
            this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/database?user=root");
            return c;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}

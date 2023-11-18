import java.sql.*;
import java.util.Scanner;

public class Pra1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem5", "root", "");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter option: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM first");
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2));
                    }
                    break;
                case 2:
                    System.out.print("Enter name to insert: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    String MYSQLINSERT = "INSERT INTO first(name) VALUES (?)";
                    PreparedStatement pstmt2 = con.prepareStatement(MYSQLINSERT);
                    pstmt2.setString(1, name);
                    int IN = pstmt2.executeUpdate();
                    break;
                case 3:
                    System.out.print("Enter name for delete: ");
                    sc.nextLine();
                    String nameDELETE = sc.nextLine();
                    String MYSQLDELETE = "DELETE FROM first WHERE name=?";
                    PreparedStatement pstmtDELETEMYSQL = con.prepareStatement(MYSQLDELETE);
                    pstmtDELETEMYSQL.setString(1, nameDELETE);
                    int rs2DELETE = pstmtDELETEMYSQL.executeUpdate();
                    break;

            }

        } catch (Exception error) {
            System.out.println(error);

        }
    }
}
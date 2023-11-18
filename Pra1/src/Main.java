import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem_5", "root", "");
            Connection conORACLE = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter option: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
//                    Statement stmt = con.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT * FROM first");

//                    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM first");
//                    ResultSet rs = pstmt.executeQuery();
                    String call = "{CALL first_disp()}";
                    CallableStatement call_c = con.prepareCall(call);
                    ResultSet rs = call_c.executeQuery();
                    while (rs.next()) {
                        System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2));
                    }
                    call_c.close();
                    break;
                case 2:
                    System.out.println("Enter name to insert: ");
                    sc.nextLine();
                    String name = sc.nextLine();
//                    String MYSQLINSERT = "INSERT INTO first(name) VALUES (?)";
//                    Statement stmt2 = con.createStatement();
//                    int rs2 = stmt2.executeUpdate("INSERT INTO first(name) VALUES ('" + name + "')");

//                    PreparedStatement pstmt = con.prepareStatement(MYSQLINSERT);
//                    pstmt.setString(1, name);
//                    int IN = pstmt.executeUpdate();

                    String Call = "{CALL first_p(?)}";
                    CallableStatement cptmt = con.prepareCall(Call);
                    cptmt.setString(1, name);
                    cptmt.execute();
                    cptmt.close();

                    break;
                case 3:
                    System.out.println("Enter name for delete: ");
                    sc.nextLine();
                    String nameDELETE = sc.nextLine();
//                    String MYSQLDELETE = "DELETE FROM first WHERE name=?";
//                    Statement stmt2DELETE = con.createStatement();
//                    int rs2DELETE = stmt2DELETE.executeUpdate("DELETE FROM first WHERE name='"+ nameDELETE +"'");

//                    PreparedStatement pstmtDELETEMYSQL = con.prepareStatement(MYSQLDELETE);
//                    pstmtDELETEMYSQL.setString(1, nameDELETE);
//                    int rs2DELETE = pstmtDELETEMYSQL.executeUpdate();
                    String Call2 = "{CALL first_d(?)}";
                    CallableStatement cptmt2 = con.prepareCall(Call2);
                    cptmt2.setString(1, nameDELETE);
                    int rs2DELETE =  cptmt2.executeUpdate();
                    if (rs2DELETE > 0) {
                        String DELTE = "INSERT INTO first(name) VALUES(?)";
//                        Statement stmt2ORACLE = conORACLE.createStatement();
//                        int rsORACLE = stmt2ORACLE.executeUpdate("INSERT INTO first(name) VALUES('" + nameDELETE + "')");
                        PreparedStatement pstmt2ORACLE = conORACLE.prepareStatement(DELTE);
                        pstmt2ORACLE.setString(1, nameDELETE);
                        int oraclebck = pstmt2ORACLE.executeUpdate();
                    }
                    cptmt2.close();
                    break;

                case 4:
                    Statement stmtO = conORACLE.createStatement();
                    ResultSet rsO = stmtO.executeQuery("SELECT * FROM first");
                    while (rsO.next()) {
                        System.out.println("id: " + rsO.getInt(1) + " name: " + rsO.getString(2));

                    }
                    break;

                case 5:
                    System.out.println("Enter name for insert into oracle : ");
                    sc.nextLine();
                    String nameORACLE = sc.nextLine();
//                    Statement stmt2ORACLE = conORACLE.createStatement();
//                    int rsORACLE = stmt2ORACLE.executeUpdate("INSERT INTO first(name) VALUES('" + nameORACLE + "')");
                    PreparedStatement pstmtORACLEINSERT = con.prepareStatement(nameORACLE);
                    pstmtORACLEINSERT.setString(1, nameORACLE);
                    int INO = pstmtORACLEINSERT.executeUpdate();
                    pstmtORACLEINSERT.close();
                    break;

                case 6:
                    System.out.println("Enter name for delete into oracle : ");
                    sc.nextLine();
                    String nameODELETE = sc.nextLine();
                    String orcl = "DELETE FROM first WHERE name=?";
//                    Statement stmt2ODELETE = conORACLE.createStatement();
//                    int rsODELETE = stmt2ODELETE.executeUpdate("DELETE FROM first WHERE name='" + nameODELETE + "'");
                    PreparedStatement pstmtDELETEO = con.prepareStatement(orcl);
                    pstmtDELETEO.setString(1, nameODELETE);
                    int rs2DELETEO = pstmtDELETEO.executeUpdate();
                    pstmtDELETEO.close();
                    break;
                case 7:
                    System.out.println("Enter Circle Radios: ");
                    double r = sc.nextDouble();

                    String sql1 = "{CALL circle(?,?)}";
                    CallableStatement radios = con.prepareCall(sql1);
                    radios.setDouble(1, r);
                    radios.registerOutParameter(2, java.sql.Types.FLOAT);
                    radios.execute();

                    float radios_c = radios.getFloat(2);
                    System.out.println(radios_c);
                    radios.close();
                    break;

                case 8:
                    System.out.println("Enter name to search");
                    sc.nextLine();
                    String name_store = sc.nextLine();
                    CallableStatement store = con.prepareCall("{CALL store(?)}");
                    store.setString(1, name_store);
                    ResultSet nm = store.executeQuery();
                    while(nm.next()){
                        System.out.println(nm.getInt(1) + " " + nm.getString(2));
                    }
                    break;

                case 9:
                    System.out.println("Enter name to search");
                    sc.nextLine();
                    String name_select = sc.nextLine();
                    String sql_select = "{CALL selectt(?,?,?)}";
                    CallableStatement select = con.prepareCall(sql_select);
                    select.setString(1, name_select);
                    select.registerOutParameter(2,Types.VARCHAR);
                    select.registerOutParameter(3,Types.INTEGER);
                    select.execute();
                    String str = select.getString(2);
                    int id = select.getInt(3);
                    System.out.println(id + " " +str);
                    break;
            }

        } catch (Exception error) {
            System.out.println(error);

        }
    }
}
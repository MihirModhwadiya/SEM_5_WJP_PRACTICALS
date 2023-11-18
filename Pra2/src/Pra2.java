import java.sql.*;
import java.util.Scanner;

public class Pra2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/productdb";
            String dbUser = "root";
            String dbPassword = "";

            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a product:");

            String selectProductsQuery = "SELECT * FROM products";
            PreparedStatement productStatement = conn.prepareStatement(selectProductsQuery);
            ResultSet pr = productStatement.executeQuery();

            while (pr.next()) {
                System.out.println(pr.getInt(1) + " | " + pr.getString(2) + " | " + pr.getDouble(3));
            }

            System.out.print("Enter id of Product to see its price: ");
            int userChoice = scanner.nextInt();
            String selectPriceQuery = "SELECT price FROM products WHERE id = ?";
            PreparedStatement priceStatement = conn.prepareStatement(selectPriceQuery);
            priceStatement.setInt(1, userChoice);
            ResultSet priceResult = priceStatement.executeQuery();

            if (priceResult.next()) {
                double productPrice = priceResult.getDouble("price");
                System.out.println("The price of the selected product is: $" + productPrice);
            } else {
                System.out.println("Invalid choice.");
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

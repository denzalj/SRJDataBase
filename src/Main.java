

import java.sql.*;


public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/SRJDataBase";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
        Receiver receiver = new Receiver();
        String messages="";
//        while (true) {
        for (int i = 0; i < 1000; i++)
            messages =messages+"llsas ";
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT insert_words_from_text('"+messages+"')";
            ResultSet rs = stmt.executeQuery(query  );
//                while (rs.next()) {
//                    // Получение значений из результатов запроса
//                    String value = rs.getString("messages");
//                    System.out.println(value);
//                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        }
    }
}
